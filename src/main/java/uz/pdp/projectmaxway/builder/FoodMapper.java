package uz.pdp.projectmaxway.builder;

import uz.pdp.projectmaxway.entity.Filial;
import uz.pdp.projectmaxway.entity.Food;
import uz.pdp.projectmaxway.payload.FilialDTO;
import uz.pdp.projectmaxway.payload.FoodDTO;

public class FoodMapper {
    public static Food toEntity(FoodDTO foodDTO){
        return Food.builder()
                .name(foodDTO.getName())
                .description(foodDTO.getDescription())
                .price(foodDTO.getPrice())
                .build();
    }

    public static Food mapper(FoodDTO foodDTO,Food food){
        food.setName(foodDTO.getName());
        food.setDescription(foodDTO.getDescription());
        food.setPrice(foodDTO.getPrice());
        return food;
    }
}
