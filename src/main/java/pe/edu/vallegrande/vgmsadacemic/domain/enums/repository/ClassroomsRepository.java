package pe.edu.vallegrande.vgmsadacemic.domain.enums.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.vgmsadacemic.domain.enums.Classrooms;
import reactor.core.publisher.Flux;

public interface ClassroomsRepository extends ReactiveMongoRepository<Classrooms, String> {
    Flux<Classrooms> findBySedeId(String sedeId);
}
