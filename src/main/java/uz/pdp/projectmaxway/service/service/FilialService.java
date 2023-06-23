package uz.pdp.projectmaxway.service.service;

import org.springframework.stereotype.Service;
import uz.pdp.projectmaxway.entity.Filial;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.FilialDTO;

import java.util.List;


public interface FilialService {


    ApiResponse<String> add(FilialDTO filialDTO);

    ApiResponse<List<Filial>> get();

    ApiResponse<String> edit(FilialDTO filialDTO, Integer id);

    ApiResponse<String> delete(Integer id);
}
