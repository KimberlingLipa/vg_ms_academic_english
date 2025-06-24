package pe.edu.vallegrande.vgmsadacemic.infrastructure.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.vgmsadacemic.domain.model.EducationalLevels;
import reactor.core.publisher.Mono;

public interface EducationalLevelsRepository extends ReactiveMongoRepository<EducationalLevels, String> {
    Mono<EducationalLevels> findByLevelCode(String levelCode);
}