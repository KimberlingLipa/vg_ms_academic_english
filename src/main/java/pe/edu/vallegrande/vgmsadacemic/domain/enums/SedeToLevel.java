package pe.edu.vallegrande.vgmsadacemic.domain.enums;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "sede_to_level")
public class SedeToLevel {
    @Id
    private String id;
    private String sedeId;
    private String levelId;
    private String status = "A"; // Default to Active
}
