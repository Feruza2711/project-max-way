package uz.pdp.projectmaxway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.projectmaxway.entity.Food;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.FoodDTO;
import uz.pdp.projectmaxway.service.service.FoodService;
import uz.pdp.projectmaxway.utils.AppConstants;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(FoodController.BASE_PATH)
@RequiredArgsConstructor
public class FoodController {

    public static final String BASE_PATH= AppConstants.BASE_PATH+"/food";
    private final FoodService foodService;

    @PostMapping("/{id}")
    public ApiResponse<String> add(@RequestBody FoodDTO foodDTO,@PathVariable Integer id){
        return foodService.add(foodDTO,id);
    }

    @GetMapping()
    public ApiResponse<List<Food>> get(){
        return foodService.get();
    }

    @GetMapping("/{id}")
    public ApiResponse<List<Food>> getFoodByCategory(@PathVariable Integer id){
        return foodService.getByCategory(id);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> edit(@RequestBody FoodDTO foodDTO,@PathVariable UUID id){
        return foodService.edit(foodDTO,id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable UUID id){
        return foodService.delete(id);
    }

}
