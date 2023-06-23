package uz.pdp.projectmaxway.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FoodDTO {
    @NotBlank
    private String name;
    @NotBlank
    private double price;
    private String description;
}
