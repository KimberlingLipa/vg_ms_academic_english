package pe.edu.vallegrande.vgmsadacemic.infrastructure.service;

import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.request.EducationalLevelsRequest;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.response.EducationalLevelsResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EducationalLevelsService {

    Flux<EducationalLevelsResponse> findAll();

    Mono<EducationalLevelsResponse> findById(String id);

    Mono<EducationalLevelsResponse> findByLevelCode(String levelCode);

    Mono<EducationalLevelsResponse> create(EducationalLevelsRequest request);

    Mono<EducationalLevelsResponse> update(String id, EducationalLevelsRequest request);

    Mono<Void> delete(String id);
}