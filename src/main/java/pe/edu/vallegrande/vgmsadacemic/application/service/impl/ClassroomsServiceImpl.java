package pe.edu.vallegrande.vgmsadacemic.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.vgmsadacemic.application.service.ClassroomsService;
import pe.edu.vallegrande.vgmsadacemic.domain.enums.Classrooms;
import pe.edu.vallegrande.vgmsadacemic.domain.enums.repository.ClassroomsRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClassroomsServiceImpl implements ClassroomsService {

    private final ClassroomsRepository repository;

    @Override
    public Flux<Classrooms> findAll() {
        return repository.findAll()
                .filter(classroom -> "A".equals(classroom.getStatus()));
    }

    @Override
    public Mono<Classrooms> findById(String id) {
        return repository.findById(id)
                .filter(classroom -> "A".equals(classroom.getStatus()));
    }

    @Override
    public Flux<Classrooms> findBySedeId(String sedeId) {
        return repository.findBySedeId(sedeId)
                .filter(classroom -> "A".equals(classroom.getStatus()));
    }

    @Override
    public Mono<Classrooms> create(Classrooms classroom) {
        classroom.setStatus("A");
        return repository.save(classroom);
    }

    @Override
    public Mono<Classrooms> update(String id, Classrooms classroom) {
        return repository.findById(id)
                .filter(existing -> "A".equals(existing.getStatus()))
                .flatMap(existing -> {
                    if (classroom.getSedeId() != null) {
                        existing.setSedeId(classroom.getSedeId());
                    }
                    if (classroom.getSection() != null) {
                        existing.setSection(classroom.getSection());
                    }
                    if (classroom.getClassroomName() != null) {
                        existing.setClassroomName(classroom.getClassroomName());
                    }
                    if (classroom.getStatus() != null) {
                        existing.setStatus(classroom.getStatus());
                    }
                    return repository.save(existing);
                });
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.findById(id)
                .filter(classroom -> "A".equals(classroom.getStatus()))
                .flatMap(classroom -> {
                    classroom.setStatus("I");
                    return repository.save(classroom).then();
                });
    }
}