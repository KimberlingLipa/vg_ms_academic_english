package pe.edu.vallegrande.vgmsadacemic.infrastructure.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.vgmsadacemic.domain.model.TeacherCoursesClassroom;
import reactor.core.publisher.Flux;

public interface TeacherCoursesClassroomRepository extends ReactiveMongoRepository<TeacherCoursesClassroom, String> {
    Flux<TeacherCoursesClassroom> findByTeacherId(String teacherId);
}