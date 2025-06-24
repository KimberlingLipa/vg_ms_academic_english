package pe.edu.vallegrande.vgmsadacemic.infrastructure.service;

import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.request.AcademicPeriodsRequest;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.response.AcademicPeriodsResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AcademicPeriodsService {

    Flux<AcademicPeriodsResponse> findAll();

    Mono<AcademicPeriodsResponse> findById(String id);

    Flux<AcademicPeriodsResponse> findByInstitutionId(String institutionId);

    Mono<AcademicPeriodsResponse> create(AcademicPeriodsRequest request);

    Mono<AcademicPeriodsResponse> update(String id, AcademicPeriodsRequest request);

    Mono<Void> delete(String id);
}