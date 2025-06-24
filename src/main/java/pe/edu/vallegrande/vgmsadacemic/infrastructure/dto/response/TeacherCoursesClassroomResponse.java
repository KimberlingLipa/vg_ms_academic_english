package pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.response;

import lombok.Data;

@Data
public class TeacherCoursesClassroomResponse {
    private String id;
    private String teacherId;
    private String coursesId;
    private String classroomId;
    private String status;
}