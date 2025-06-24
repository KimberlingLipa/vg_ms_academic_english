package pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.request;

import lombok.Data;

@Data
public class EducationalLevelsRequest {
    private String levelName;
    private String levelCode;
    private String description;
    private String status;
}