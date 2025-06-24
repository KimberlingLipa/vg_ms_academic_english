package pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.request;

import lombok.Data;

@Data
public class TeacherCoursesClassroomRequest {
    private String teacherId;
    private String coursesId;
    private String classroomId;
    private String status;
}