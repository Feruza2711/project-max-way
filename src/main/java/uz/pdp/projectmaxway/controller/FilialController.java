package uz.pdp.projectmaxway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.projectmaxway.entity.Filial;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.FilialDTO;
import uz.pdp.projectmaxway.service.service.FilialService;
import uz.pdp.projectmaxway.utils.AppConstants;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(FilialController.BASE_PATH)
public class FilialController {
    public static final String BASE_PATH= AppConstants.BASE_PATH+"/filial";
    private final FilialService filialService;

    @GetMapping()
    public ApiResponse<List<Filial>> get(){
        return filialService.get();
    }

    @PostMapping()
    public ApiResponse<String> add(@RequestBody FilialDTO filialDTO){
        return filialService.add(filialDTO);
    }

    @PutMapping("/{id}")
    public ApiResponse<String> edit(@RequestBody FilialDTO filialDTO, @PathVariable Integer id){
        return filialService.edit(filialDTO,id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(@PathVariable Integer id){
        return filialService.delete(id);
    }

}
