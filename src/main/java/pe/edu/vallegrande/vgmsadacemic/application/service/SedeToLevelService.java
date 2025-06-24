package pe.edu.vallegrande.vgmsadacemic.application.service;

import pe.edu.vallegrande.vgmsadacemic.domain.enums.SedeToLevel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SedeToLevelService {

    Flux<SedeToLevel> findAll();

    Mono<SedeToLevel> findById(String id);

    Flux<SedeToLevel> findBySedeId(String sedeId);

    Mono<SedeToLevel> create(SedeToLevel sedeToLevel);

    Mono<SedeToLevel> update(String id, SedeToLevel sedeToLevel);

    Mono<Void> delete(String id);
}