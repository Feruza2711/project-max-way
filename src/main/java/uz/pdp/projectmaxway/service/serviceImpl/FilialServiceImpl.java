package uz.pdp.projectmaxway.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.projectmaxway.builder.FilialMapper;
import uz.pdp.projectmaxway.entity.Filial;
import uz.pdp.projectmaxway.exceptions.RestExeption;
import uz.pdp.projectmaxway.payload.ApiResponse;
import uz.pdp.projectmaxway.payload.FilialDTO;
import uz.pdp.projectmaxway.repository.FilialRepository;
import uz.pdp.projectmaxway.service.service.FilialService;
import uz.pdp.projectmaxway.utils.ResponseMessage;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilialServiceImpl implements FilialService {
    private final FilialRepository filialRepository;

    @Override
    public ApiResponse<String> add(FilialDTO filialDTO) {
        if(!filialDTO.getStart_time().isBefore(filialDTO.getEnd_time())){
            throw RestExeption.restThrow("Time is not available");
        }
        Filial filial = FilialMapper.toEntity(filialDTO);
        filialRepository.save(filial);
        return ApiResponse.successResponse(ResponseMessage.OK);
    }

    @Override
    public ApiResponse<List<Filial>> get() {
        return ApiResponse.successResponse(filialRepository.findAll());
    }

    @Override
    public ApiResponse<String> edit(FilialDTO filialDTO, Integer id) {
        Optional<Filial> filialOptional = filialRepository.findById(id);
        if(!filialOptional.isPresent()) throw RestExeption.restThrow(ResponseMessage.NOT_FOUND);
        Filial filial = FilialMapper.mapper(filialDTO, filialOptional.get());
        filialRepository.save(filial);
        return ApiResponse.successResponse(ResponseMessage.OK);
    }

    @Override
    public ApiResponse<String> delete(Integer id) {
        try {
            if(filialRepository.existsById(id))
                throw RestExeption.restThrow(ResponseMessage.NOT_FOUND);
            filialRepository.deleteById(id);
        } catch (Exception e) {
            throw RestExeption.restThrow(ResponseMessage.ERROR);
        }
        return ApiResponse.successResponse(ResponseMessage.OK);
    }
}
