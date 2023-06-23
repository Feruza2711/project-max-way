package uz.pdp.projectmaxway.payload;

import lombok.Data;
import uz.pdp.projectmaxway.entity.enums.Status;

@Data
public class UserDAO {
    private String name;
    private String phoneNumber;
    private int orderCount;
    private Status status;
}
