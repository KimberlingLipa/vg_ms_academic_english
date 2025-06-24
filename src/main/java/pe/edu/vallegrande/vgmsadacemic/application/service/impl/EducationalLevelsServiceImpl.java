package pe.edu.vallegrande.vgmsadacemic.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.vgmsadacemic.domain.model.EducationalLevels;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.request.EducationalLevelsRequest;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.response.EducationalLevelsResponse;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.repository.EducationalLevelsRepository;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.service.EducationalLevelsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EducationalLevelsServiceImpl implements EducationalLevelsService {

    private final EducationalLevelsRepository repository;

    @Override
    public Flux<EducationalLevelsResponse> findAll() {
        return repository.findAll()
                .filter(level -> "A".equals(level.getStatus()))
                .map(this::mapToResponse);
    }

    @Override
    public Mono<EducationalLevelsResponse> findById(String id) {
        return repository.findById(id)
                .filter(level -> "A".equals(level.getStatus()))
                .map(this::mapToResponse);
    }

    @Override
    public Mono<EducationalLevelsResponse> findByLevelCode(String levelCode) {
        return repository.findByLevelCode(levelCode)
                .filter(level -> "A".equals(level.getStatus()))
                .map(this::mapToResponse);
    }

    @Override
    public Mono<EducationalLevelsResponse> create(EducationalLevelsRequest request) {
        EducationalLevels educationalLevels = new EducationalLevels();
        educationalLevels.setLevelName(request.getLevelName());
        educationalLevels.setLevelCode(request.getLevelCode());
        educationalLevels.setDescription(request.getDescription());
        educationalLevels.setStatus("A"); // Default to Active
        return repository.save(educationalLevels)
                .map(this::mapToResponse);
    }

    @Override
    public Mono<EducationalLevelsResponse> update(String id, EducationalLevelsRequest request) {
        return repository.findById(id)
                .filter(level -> "A".equals(level.getStatus()))
                .flatMap(existing -> {
                    if (request.getLevelName() != null) {
                        existing.setLevelName(request.getLevelName());
                    }
                    if (request.getLevelCode() != null) {
                        existing.setLevelCode(request.getLevelCode());
                    }
                    if (request.getDescription() != null) {
                        existing.setDescription(request.getDescription());
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
                .filter(level -> "A".equals(level.getStatus()))
                .flatMap(level -> {
                    level.setStatus("I");
                    return repository.save(level).then();
                });
    }

    private EducationalLevelsResponse mapToResponse(EducationalLevels educationalLevels) {
        EducationalLevelsResponse response = new EducationalLevelsResponse();
        response.setId(educationalLevels.getId());
        response.setLevelName(educationalLevels.getLevelName());
        response.setLevelCode(educationalLevels.getLevelCode());
        response.setDescription(educationalLevels.getDescription());
        response.setStatus(educationalLevels.getStatus());
        return response;
    }
}