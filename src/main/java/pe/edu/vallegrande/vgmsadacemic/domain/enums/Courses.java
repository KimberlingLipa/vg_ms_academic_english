package pe.edu.vallegrande.vgmsadacemic.domain.enums;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "courses")
public class Courses {
    @Id
    private String id;
    private String institutionId;
    private String coursesName;
    private String status = "A"; // Default to Active
}
