package pe.edu.vallegrande.vgmsadacemic.application.service;

import pe.edu.vallegrande.vgmsadacemic.domain.enums.Classrooms;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClassroomsService {

    Flux<Classrooms> findAll();

    Mono<Classrooms> findById(String id);

    Flux<Classrooms> findBySedeId(String sedeId);

    Mono<Classrooms> create(Classrooms classroom);

    Mono<Classrooms> update(String id, Classrooms classroom);

    Mono<Void> delete(String id);
}