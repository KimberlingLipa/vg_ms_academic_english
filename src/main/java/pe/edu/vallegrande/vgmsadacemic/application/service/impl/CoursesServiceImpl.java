package pe.edu.vallegrande.vgmsadacemic.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.vgmsadacemic.application.service.CoursesService;
import pe.edu.vallegrande.vgmsadacemic.domain.enums.Courses;
import pe.edu.vallegrande.vgmsadacemic.domain.enums.repository.CoursesRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService {

    private final CoursesRepository repository;

    @Override
    public Flux<Courses> findAll() {
        return repository.findAll()
                .filter(course -> "A".equals(course.getStatus()));
    }

    @Override
    public Mono<Courses> findById(String id) {
        return repository.findById(id)
                .filter(course -> "A".equals(course.getStatus()));
    }

    @Override
    public Flux<Courses> findByInstitutionId(String institutionId) {
        return repository.findByInstitutionId(institutionId)
                .filter(course -> "A".equals(course.getStatus()));
    }

    @Override
    public Mono<Courses> create(Courses course) {
        course.setStatus("A");
        return repository.save(course);
    }

    @Override
    public Mono<Courses> update(String id, Courses course) {
        return repository.findById(id)
                .filter(existing -> "A".equals(existing.getStatus()))
                .flatMap(existing -> {
                    if (course.getInstitutionId() != null) {
                        existing.setInstitutionId(course.getInstitutionId());
                    }
                    if (course.getCoursesName() != null) {
                        existing.setCoursesName(course.getCoursesName());
                    }
                    if (course.getStatus() != null) {
                        existing.setStatus(course.getStatus());
                    }
                    return repository.save(existing);
                });
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.findById(id)
                .filter(course -> "A".equals(course.getStatus()))
                .flatMap(course -> {
                    course.setStatus("I");
                    return repository.save(course).then();
                });
    }
}