package pe.edu.vallegrande.vgmsadacemic.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "teacher_courses_classroom")
public class TeacherCoursesClassroom {
    @Id
    private String id;
    private String teacherId;
    private String coursesId;
    private String classroomId;
    private String status = "A"; // Default to Active
}