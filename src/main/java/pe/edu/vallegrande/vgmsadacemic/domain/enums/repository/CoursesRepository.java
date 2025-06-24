package pe.edu.vallegrande.vgmsadacemic.domain.enums.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.vgmsadacemic.domain.enums.Courses;
import reactor.core.publisher.Flux;

public interface CoursesRepository extends ReactiveMongoRepository<Courses, String> {
    Flux<Courses> findByInstitutionId(String institutionId);
}
