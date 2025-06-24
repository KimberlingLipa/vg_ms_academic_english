package pe.edu.vallegrande.vgmsadacemic.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "academic_periods")
public class AcademicPeriods {
    @Id
    private String id;
    private String institutionId;
    private String periodName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status = "A"; // Default to Active
}