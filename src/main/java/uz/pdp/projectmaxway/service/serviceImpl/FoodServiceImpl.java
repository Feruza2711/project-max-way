package uz.pdp.projectmaxway.service.serviceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.projectmaxway.builder.FoodMapper;
import uz.pdp.projectmaxway.entity.Category;
import uz.pdp.projectmaxway.entity.Food;
import uz.pdp.projectmaxway.utils.ResponseMessage;
import uz.pdp.projectmaxway.exceptions.RestExeption;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.FoodDTO;
import uz.pdp.projectmaxway.repository.CategoryRepository;
import uz.pdp.projectmaxway.repository.FoodRepository;
import uz.pdp.projectmaxway.service.service.FoodService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ApiResponse<String> add(FoodDTO foodDTO,Integer id) {
        Food food = FoodMapper.toEntity(foodDTO);
        Optional<Category> byId = categoryRepository.findById(id);
        if(byId.isEmpty()){
            throw RestExeption.restThrow(ResponseMessage.NOT_FOUND);
        }
        food.setCategory(byId.get());
        foodRepository.save(food);
        return ApiResponse.succesResponce(ResponseMessage.OK);
    }

    @Override
    public ApiResponse<List<Food>> get() {
        return ApiResponse.successResponse(foodRepository.findAll());
    }

    @Override
    public ApiResponse<String> edit(FoodDTO foodDTO, UUID id) {
        Optional<Food> foodOptional = foodRepository.findById(id);
        if(!foodOptional.isPresent()) throw RestExeption.restThrow(ResponseMessage.NOT_FOUND);
        Food food = FoodMapper.mapper(foodDTO, foodOptional.get());
        foodRepository.save(food);
        return ApiResponse.successResponse(ResponseMessage.OK);
    }

    @Override
    public ApiResponse<String> delete(UUID id) {
        try {
           if(!foodRepository.existsById(id))
               throw RestExeption.restThrow(ResponseMessage.NOT_FOUND);
            foodRepository.deleteById(id);
        } catch (Exception e) {
            throw RestExeption.restThrow(ResponseMessage.ERROR);
        }
        return ApiResponse.successResponse(ResponseMessage.OK);
    }

    @Override
    public ApiResponse<List<Food>> getByCategory(Integer id) {
     List<Food> foods= foodRepository.findByCategoryId(id);
        return ApiResponse.successResponse(foods);
    }

}
