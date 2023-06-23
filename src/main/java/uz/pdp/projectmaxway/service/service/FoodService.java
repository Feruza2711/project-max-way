package uz.pdp.projectmaxway.service.service;

import org.springframework.stereotype.Service;
import uz.pdp.projectmaxway.entity.Food;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.FoodDTO;

import java.util.List;
import java.util.UUID;


public interface FoodService {
    ApiResponse<String> add(FoodDTO foodDTO, Integer id);

    ApiResponse<List<Food>> get();

    ApiResponse<String> edit(FoodDTO foodDTO, UUID id);

    ApiResponse<String> delete(UUID id);

    ApiResponse<List<Food>> getByCategory(Integer id);
}
