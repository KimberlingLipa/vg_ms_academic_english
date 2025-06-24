package pe.edu.vallegrande.vgmsadacemic.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.vgmsadacemic.domain.model.AcademicPeriods;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.request.AcademicPeriodsRequest;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.response.AcademicPeriodsResponse;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.repository.AcademicPeriodsRepository;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.service.AcademicPeriodsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AcademicPeriodsServiceImpl implements AcademicPeriodsService {

    private final AcademicPeriodsRepository repository;

    @Override
    public Flux<AcademicPeriodsResponse> findAll() {
        return repository.findAll()
                .filter(period -> "A".equals(period.getStatus()))
                .map(this::mapToResponse);
    }

    @Override
    public Mono<AcademicPeriodsResponse> findById(String id) {
        return repository.findById(id)
                .filter(period -> "A".equals(period.getStatus()))
                .map(this::mapToResponse);
    }

    @Override
    public Flux<AcademicPeriodsResponse> findByInstitutionId(String institutionId) {
        return repository.findByInstitutionId(institutionId)
                .filter(period -> "A".equals(period.getStatus()))
                .map(this::mapToResponse);
    }

    @Override
    public Mono<AcademicPeriodsResponse> create(AcademicPeriodsRequest request) {
        AcademicPeriods academicPeriods = new AcademicPeriods();
        academicPeriods.setInstitutionId(request.getInstitutionId());
        academicPeriods.setPeriodName(request.getPeriodName());
        academicPeriods.setStartDate(request.getStartDate());
        academicPeriods.setEndDate(request.getEndDate());
        academicPeriods.setStatus("A"); // Default to Active
        return repository.save(academicPeriods)
                .map(this::mapToResponse);
    }

    @Override
    public Mono<AcademicPeriodsResponse> update(String id, AcademicPeriodsRequest request) {
        return repository.findById(id)
                .filter(period -> "A".equals(period.getStatus()))
                .flatMap(existing -> {
                    if (request.getInstitutionId() != null) {
                        existing.setInstitutionId(request.getInstitutionId());
                    }
                    if (request.getPeriodName() != null) {
                        existing.setPeriodName(request.getPeriodName());
                    }
                    if (request.getStartDate() != null) {
                        existing.setStartDate(request.getStartDate());
                    }
                    if (request.getEndDate() != null) {
                        existing.setEndDate(request.getEndDate());
                    }
                    if (request.getStatus() != null) {
                        existing.setStatus(request.getStatus());
                    }
                    return repository.save(existing);
                })
                .map(this::mapToResponse);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.findById(id)
                .filter(period -> "A".equals(period.getStatus()))
                .flatMap(period -> {
                    period.setStatus("I");
                    return repository.save(period).then();
                });
    }

    private AcademicPeriodsResponse mapToResponse(AcademicPeriods academicPeriods) {
        AcademicPeriodsResponse response = new AcademicPeriodsResponse();
        response.setId(academicPeriods.getId());
        response.setInstitutionId(academicPeriods.getInstitutionId());
        response.setPeriodName(academicPeriods.getPeriodName());
        response.setStartDate(academicPeriods.getStartDate());
        response.setEndDate(academicPeriods.getEndDate());
        response.setStatus(academicPeriods.getStatus());
        return response;
    }
}