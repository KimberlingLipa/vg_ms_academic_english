package pe.edu.vallegrande.vgmsadacemic.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.vgmsadacemic.application.service.SedeToLevelService;
import pe.edu.vallegrande.vgmsadacemic.domain.enums.SedeToLevel;
import pe.edu.vallegrande.vgmsadacemic.domain.enums.repository.SedeToLevelRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SedeToLevelServiceImpl implements SedeToLevelService {

    private final SedeToLevelRepository repository;

    @Override
    public Flux<SedeToLevel> findAll() {
        return repository.findAll()
                .filter(sedeToLevel -> "A".equals(sedeToLevel.getStatus()));
    }

    @Override
    public Mono<SedeToLevel> findById(String id) {
        return repository.findById(id)
                .filter(sedeToLevel -> "A".equals(sedeToLevel.getStatus()));
    }

    @Override
    public Flux<SedeToLevel> findBySedeId(String sedeId) {
        return repository.findBySedeId(sedeId)
                .filter(sedeToLevel -> "A".equals(sedeToLevel.getStatus()));
    }

    @Override
    public Mono<SedeToLevel> create(SedeToLevel sedeToLevel) {
        sedeToLevel.setStatus("A");
        return repository.save(sedeToLevel);
    }

    @Override
    public Mono<SedeToLevel> update(String id, SedeToLevel sedeToLevel) {
        return repository.findById(id)
                .filter(existing -> "A".equals(existing.getStatus()))
                .flatMap(existing -> {
                    if (sedeToLevel.getSedeId() != null) {
                        existing.setSedeId(sedeToLevel.getSedeId());
                    }
                    if (sedeToLevel.getLevelId() != null) {
                        existing.setLevelId(sedeToLevel.getLevelId());
                    }
                    if (sedeToLevel.getStatus() != null) {
                        existing.setStatus(sedeToLevel.getStatus());
                    }
                    return repository.save(existing);
                });
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.findById(id)
                .filter(sedeToLevel -> "A".equals(sedeToLevel.getStatus()))
                .flatMap(sedeToLevel -> {
                    sedeToLevel.setStatus("I");
                    return repository.save(sedeToLevel).then();
                });
    }
}