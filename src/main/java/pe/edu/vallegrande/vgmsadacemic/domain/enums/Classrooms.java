package pe.edu.vallegrande.vgmsadacemic.domain.enums;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "classrooms")
public class Classrooms {
    @Id
    private String id;
    private String sedeId;
    private String section;
    private String classroomName;
    private String status = "A"; // Default to Active
}
