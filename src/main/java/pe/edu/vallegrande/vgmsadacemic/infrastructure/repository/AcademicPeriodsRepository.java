package pe.edu.vallegrande.vgmsadacemic.infrastructure.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.vgmsadacemic.domain.model.AcademicPeriods;
import reactor.core.publisher.Flux;

public interface AcademicPeriodsRepository extends ReactiveMongoRepository<AcademicPeriods, String> {
    Flux<AcademicPeriods> findByInstitutionId(String institutionId);
}