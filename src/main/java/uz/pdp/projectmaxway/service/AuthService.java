package uz.pdp.projectmaxway.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.projectmaxway.entity.User;
import uz.pdp.projectmaxway.entity.enums.RoleTypeEnum;
import uz.pdp.projectmaxway.exceptions.RestExeption;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.SignInDTO;
import uz.pdp.projectmaxway.payload.SignUpDTO;
import uz.pdp.projectmaxway.payload.TokenDTO;
import uz.pdp.projectmaxway.repository.RoleRepository;
import uz.pdp.projectmaxway.repository.UserRepository;
import uz.pdp.projectmaxway.security.JwtProvider;
import uz.pdp.projectmaxway.security.UserPrinsipal;

import java.util.Random;
import java.util.concurrent.CompletableFuture;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final RoleRepository roleRepository;
    private final SendSms sendSms;


    public AuthService(UserRepository userRepository,
                       @Lazy PasswordEncoder passwordEncoder,
                       @Lazy AuthenticationManager authenticationManager, JwtProvider jwtProvider, RoleRepository roleRepository, SendSms sendSms) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.roleRepository = roleRepository;
        this.sendSms = sendSms;
    }



    public ApiResponse<String> signUp(SignUpDTO signDTO) {
        if (userRepository.existsByPhoneNumber(signDTO.getPhoneNumber()))
            throw RestExeption.restThrow("This user already exits");

        User user = new User(
                signDTO.getName(),
                signDTO.getPhoneNumber(),
                passwordEncoder.encode(signDTO.getPassword()),
                roleRepository.findByRoleTypeEnum(RoleTypeEnum.USER).orElseThrow()
        );
        user.setEnabled(false);
        String code = sendSms.SendSmsPhoneNumber(user.getPhoneNumber());
        user.setVerificationCode(code);
        userRepository.save(user);
        return ApiResponse.succesResponce("OK");
    }


    public ApiResponse<TokenDTO> signIn(SignInDTO signDTO) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signDTO.getPhoneNumber(),
                        signDTO.getPassword()
                )
        );

        UserPrinsipal userPrincipal =(UserPrinsipal) authenticate.getPrincipal();



        return ApiResponse.successResponse(
                TokenDTO.builder()
                        .accessToken(jwtProvider.generateAccessToken(userPrincipal))
                        .refreshToken(jwtProvider.generateRefreshToken(userPrincipal))
                        .build()
        );

    }


    public ApiResponse<String> verificationPhoneNumberCode(String code) {
        User user = userRepository.findByVerificationCode(code).orElseThrow();
        if (user.isEnabled())
            throw RestExeption.restThrow(
                    "This user already be active",
                    HttpStatus.CONFLICT);

        user.setEnabled(true);
        userRepository.save(user);
        return ApiResponse.successResponse("Successfully active");
    }
}


