package pe.edu.vallegrande.vgmsadacemic.domain.enums.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.vgmsadacemic.domain.enums.SedeToLevel;
import reactor.core.publisher.Flux;

public interface SedeToLevelRepository extends ReactiveMongoRepository<SedeToLevel, String> {
    Flux<SedeToLevel> findBySedeId(String sedeId);
}
