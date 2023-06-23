package uz.pdp.projectmaxway.payload;

import lombok.Data;
import uz.pdp.projectmaxway.entity.Category;

@Data
public class CategoryDTO {
    private String name;
    private Integer parent_category;
}
