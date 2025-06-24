package pe.edu.vallegrande.vgmsadacemic.application.service;

import pe.edu.vallegrande.vgmsadacemic.domain.enums.Courses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoursesService {

    Flux<Courses> findAll();

    Mono<Courses> findById(String id);

    Flux<Courses> findByInstitutionId(String institutionId);

    Mono<Courses> create(Courses course);

    Mono<Courses> update(String id, Courses course);

    Mono<Void> delete(String id);
}