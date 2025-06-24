package pe.edu.vallegrande.vgmsadacemic.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "educational_levels")
public class EducationalLevels {
    @Id
    private String id;
    private String levelName;
    private String levelCode;
    private String description;
    private String status = "A"; // Default to Active
}