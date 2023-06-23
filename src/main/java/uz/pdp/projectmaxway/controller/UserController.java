package uz.pdp.projectmaxway.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.projectmaxway.entity.enums.Status;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.UserDAO;
import uz.pdp.projectmaxway.payload.UserDTO;
import uz.pdp.projectmaxway.service.service.UserService;
import uz.pdp.projectmaxway.utils.AppConstants;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(UserController.BASE_PATH)
@RequiredArgsConstructor
public class UserController {
    public static final String BASE_PATH= AppConstants.BASE_PATH+"/user";
    private final UserService userService;

    @PostMapping
    public ApiResponse<String> add(@Valid @RequestBody UserDTO userDTO){
        return userService.add(userDTO);
    }

    @GetMapping
    public ApiResponse<List<UserDAO>> get(){
        return userService.get();
    }

    @PutMapping("/{id}")
    public ApiResponse<String> edit(@Valid @RequestBody UserDTO userDTO,@PathVariable UUID id){
        return userService.edit(userDTO,id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete ( @Valid @PathVariable UUID id){
        return userService.delete(id);
    }

    @PostMapping("/{id}")
    public ApiResponse<String> changeStatus(@Valid @PathVariable UUID id, @RequestParam boolean status){
          return userService.changeStatus(id,status);
    }


}
