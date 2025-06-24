package pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AcademicPeriodsRequest {
    private String institutionId;
    private String periodName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}