package uz.pdp.projectmaxway.service.service;

import org.springframework.stereotype.Service;
import uz.pdp.projectmaxway.entity.Category;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.CategoryDTO;

import java.util.List;

public interface CategoryService {

    public ApiResponse<String> add(CategoryDTO categoryDTO);


    public ApiResponse<List<Category>> get();


    public ApiResponse<String> edit(CategoryDTO categoryDTO, Integer id);


    public ApiResponse<String> delete(Integer id);

}
