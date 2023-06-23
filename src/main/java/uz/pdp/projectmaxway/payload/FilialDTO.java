package uz.pdp.projectmaxway.payload;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FilialDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private LocalDateTime start_time;
    private LocalDateTime end_time;
}
