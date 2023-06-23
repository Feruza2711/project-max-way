package uz.pdp.projectmaxway.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.projectmaxway.entity.enums.Status;

@Data
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String phoneNumber;
    private int orderCount;
    private boolean status;

    public UserDTO(String name, String phoneNumber, int orderCount,boolean status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.orderCount = orderCount;
        this.status=status;
    }
}
