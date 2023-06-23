package uz.pdp.projectmaxway.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.projectmaxway.builder.UserMapper;
import uz.pdp.projectmaxway.entity.User;
import uz.pdp.projectmaxway.entity.enums.Status;
import uz.pdp.projectmaxway.exceptions.RestExeption;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.UserDAO;
import uz.pdp.projectmaxway.payload.UserDTO;
import uz.pdp.projectmaxway.repository.UserRepository;
import uz.pdp.projectmaxway.service.service.UserService;
import uz.pdp.projectmaxway.utils.ResponseMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public ApiResponse<String> add(UserDTO userDTO) {
        try {
            User user = UserMapper.toEntity(userDTO);
            userRepository.save(user);
        } catch (Exception e) {
            throw RestExeption.restThrow(e.getMessage());
        }
        return ApiResponse.successResponse(ResponseMessage.OK);
    }

    @Override
    public ApiResponse<List<UserDAO>> get() {
        List<UserDAO> userDAOList=new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            UserDAO userDAO=new UserDAO();
            userDAO.setName(user.getName());
            userDAO.setPhoneNumber(user.getPhoneNumber());
            userDAO.setOrderCount(user.getOrderCount());
            userDAO.setStatus(user.getStatus());
            userDAOList.add(userDAO);
        }
        return ApiResponse.successResponse(userDAOList);
    }

    @Override
    public ApiResponse<String> edit(UserDTO userDTO, UUID id) {
        Optional<User> byId = userRepository.findById(id);
        if(byId.isEmpty()) throw RestExeption.restThrow(ResponseMessage.NOT_FOUND);
        try {
            User user=UserMapper.mapper(userDTO,byId.get());
            userRepository.save(user);
        } catch (Exception e) {
            throw RestExeption.restThrow(e.getMessage());
        }
        return ApiResponse.successResponse(ResponseMessage.OK);
    }

    @Override
    public ApiResponse<String> delete(UUID id) {
        try {
            if(!userRepository.existsById(id)) throw RestExeption.restThrow(ResponseMessage.NOT_FOUND);
                userRepository.deleteById(id);
        } catch (RestExeption e) {
            throw RestExeption.restThrow(e.getMessage());
        }
        return ApiResponse.successResponse(ResponseMessage.OK);
    }

    @Override
    public ApiResponse<String> changeStatus(UUID id, boolean status) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) throw RestExeption.restThrow(ResponseMessage.NOT_FOUND);
        User user = optionalUser.get();
        if(status){
            user.setStatus(Status.ACTIVE);
        }
        user.setStatus(Status.BLOCK);
        return ApiResponse.successResponse(ResponseMessage.OK);
    }
}
