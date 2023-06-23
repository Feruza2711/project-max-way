package uz.pdp.projectmaxway.builder;


import uz.pdp.projectmaxway.entity.Filial;
import uz.pdp.projectmaxway.payload.FilialDTO;

public class FilialMapper {

    public static Filial toEntity(FilialDTO filialDTO){
        return Filial.builder()
                .name(filialDTO.getName())
                .address(filialDTO.getAddress())
                .phoneNumber(filialDTO.getPhoneNumber())
                .start_time(filialDTO.getStart_time())
                .end_time(filialDTO.getEnd_time())
                .build();
    }

    public static Filial mapper(FilialDTO filialDTO,Filial filial){
        filial.setName(filialDTO.getName());
        filial.setAddress(filialDTO.getAddress());
        filial.setPhoneNumber(filialDTO.getPhoneNumber());
        filial.setEnd_time(filialDTO.getEnd_time());
        filial.setStart_time(filialDTO.getStart_time());
        return filial;
    }

}
