package uz.pdp.projectmaxway.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.pdp.projectmaxway.builder.CategoryMapper;
import uz.pdp.projectmaxway.entity.Category;
import uz.pdp.projectmaxway.exceptions.RestExeption;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.CategoryDTO;
import uz.pdp.projectmaxway.repository.CategoryRepository;
import uz.pdp.projectmaxway.service.service.CategoryService;
import uz.pdp.projectmaxway.utils.ResponseMessage;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public ApiResponse<String> add(CategoryDTO categoryDTO) {
        Category category= CategoryMapper.toEntity(categoryDTO);

        if(categoryDTO.getParent_category()!=null) {
            Optional<Category> byId = categoryRepository.findById(categoryDTO.getParent_category());
            if(!byId.isPresent()) throw RestExeption.restThrow(ResponseMessage.NOT_FOUND);
            category.setParent_category(byId.get());
        }
        categoryRepository.save(category);
        return ApiResponse.succesResponce(ResponseMessage.OK);
    }

    @Override
    public ApiResponse<List<Category>> get() {
        List<Category> data = categoryRepository.findAll();
        return ApiResponse.successResponse(data);
    }

    @Override
    public ApiResponse<String> edit(CategoryDTO categoryDTO, Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(!optionalCategory.isPresent()){
            throw RestExeption.restThrow(ResponseMessage.ERROR, HttpStatus.BAD_REQUEST);
        }
        Category category = optionalCategory.get();
        category.setName(categoryDTO.getName());
        categoryRepository.save(category);
        return ApiResponse.succesResponce(ResponseMessage.OK);
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        try {
            categoryRepository.deleteById(id);
            return ApiResponse.succesResponce(ResponseMessage.OK);
        } catch (Exception e) {
            throw RestExeption.restThrow(ResponseMessage.NOT_FOUND);
        }
    }
}
