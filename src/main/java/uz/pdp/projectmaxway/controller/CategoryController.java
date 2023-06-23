package uz.pdp.projectmaxway.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.projectmaxway.entity.Category;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.CategoryDTO;
import uz.pdp.projectmaxway.service.service.CategoryService;
import uz.pdp.projectmaxway.utils.AppConstants;
import java.util.List;

@RestController
@RequestMapping(CategoryController.BASE_PATH)
@RequiredArgsConstructor
public class CategoryController {

    public static final String BASE_PATH= AppConstants.BASE_PATH+"/category";

    private final CategoryService categoryService;

    @PostMapping()
    public ApiResponse<String> add(@RequestBody CategoryDTO categoryDTO){
        return categoryService.add(categoryDTO);
    }

    @GetMapping()
    public ApiResponse<List<Category>> get(){
        return categoryService.get();
    }

    @PutMapping("/{id}")
    public ApiResponse<String> edit(@RequestBody CategoryDTO categoryDTO,@PathVariable Integer id){
        return categoryService.edit(categoryDTO,id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Integer id){
        return categoryService.delete(id);
    }

}
