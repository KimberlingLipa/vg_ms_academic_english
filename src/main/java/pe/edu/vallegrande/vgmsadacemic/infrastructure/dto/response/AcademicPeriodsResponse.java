package pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AcademicPeriodsResponse {
    private String id;
    private String institutionId;
    private String periodName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
}