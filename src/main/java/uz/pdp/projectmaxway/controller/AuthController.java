package uz.pdp.projectmaxway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.SignInDTO;
import uz.pdp.projectmaxway.payload.SignUpDTO;
import uz.pdp.projectmaxway.payload.TokenDTO;
import uz.pdp.projectmaxway.service.AuthService;
import uz.pdp.projectmaxway.utils.AppConstants;


@RestController
@RequestMapping(AuthController.BASE_PATH)
@RequiredArgsConstructor
public class AuthController {
    public static final String BASE_PATH= AppConstants.BASE_PATH+"/auth";
    public static final String SIGN_UP_PATH = "/sign-up";
    public static final String SIGN_IN_PATH = "/sign-in";
    public static final String EMAIL_VERIFICATION_PATH = "email-verification/{code}";
    private final AuthService authService;

    @PostMapping(SIGN_UP_PATH)
    public ApiResponse<String> signUp(@RequestBody SignUpDTO signDTO) {
        return authService.signUp(signDTO);
    }


    @PostMapping(SIGN_IN_PATH)
    public ApiResponse<TokenDTO> signIn(@RequestBody SignInDTO signInDTO){
        return authService.signIn(signInDTO);

    }

    @GetMapping(EMAIL_VERIFICATION_PATH)
    public ApiResponse<String> verificationPhoneNumber(@PathVariable String code) {
        return authService.verificationPhoneNumberCode(code);
    }





}
