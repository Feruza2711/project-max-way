package uz.pdp.projectmaxway.builder;

import uz.pdp.projectmaxway.entity.Category;
import uz.pdp.projectmaxway.payload.CategoryDTO;

public class CategoryMapper {

    public static Category toEntity(CategoryDTO categoryDTO) {
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }
}
