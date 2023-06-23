package uz.pdp.projectmaxway.service.service;

import org.springframework.stereotype.Service;
import uz.pdp.projectmaxway.entity.enums.Status;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.UserDAO;
import uz.pdp.projectmaxway.payload.UserDTO;

import java.util.List;
import java.util.UUID;


public interface UserService {
    ApiResponse<String> add(UserDTO userDTO);

    ApiResponse<List<UserDAO>> get();

    ApiResponse<String> edit(UserDTO userDTO, UUID id);

    ApiResponse<String> delete(UUID id);

    ApiResponse<String> changeStatus(UUID id, boolean status);
}
