package pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.response;

import lombok.Data;

@Data
public class EducationalLevelsResponse {
    private String id;
    private String levelName;
    private String levelCode;
    private String description;
    private String status;
}