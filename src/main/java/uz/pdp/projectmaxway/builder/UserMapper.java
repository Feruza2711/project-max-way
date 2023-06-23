package uz.pdp.projectmaxway.builder;

import uz.pdp.projectmaxway.entity.User;
import uz.pdp.projectmaxway.entity.enums.Status;
import uz.pdp.projectmaxway.payload.UserDTO;

public class UserMapper {

    public static  User toEntity(UserDTO userDTO){
        User user=new User();
        user.setName(userDTO.getName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setOrderCount(userDTO.getOrderCount());
        if(userDTO.isStatus()){
            user.setStatus(Status.ACTIVE);
        }
        user.setStatus(Status.BLOCK);
        return user;
    }

    public static User mapper(UserDTO userDTO, User user) {

      user.setName(userDTO.getName());
      user.setPhoneNumber(userDTO.getPhoneNumber());
      user.setOrderCount(userDTO.getOrderCount());
        if(userDTO.isStatus()){
            user.setStatus(Status.ACTIVE);
        }
        user.setStatus(Status.BLOCK);
        return user;
    }

}
