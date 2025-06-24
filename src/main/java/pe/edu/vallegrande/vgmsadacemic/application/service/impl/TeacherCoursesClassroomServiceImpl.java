package pe.edu.vallegrande.vgmsadacemic.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.vgmsadacemic.domain.model.TeacherCoursesClassroom;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.request.TeacherCoursesClassroomRequest;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.response.TeacherCoursesClassroomResponse;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.repository.TeacherCoursesClassroomRepository;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.service.TeacherCoursesClassroomService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TeacherCoursesClassroomServiceImpl implements TeacherCoursesClassroomService {

    private final TeacherCoursesClassroomRepository repository;

    @Override
    public Flux<TeacherCoursesClassroomResponse> findAll() {
        return repository.findAll()
                .filter(tcc -> "A".equals(tcc.getStatus()))
                .map(this::mapToResponse);
    }

    @Override
    public Mono<TeacherCoursesClassroomResponse> findById(String id) {
        return repository.findById(id)
                .filter(tcc -> "A".equals(tcc.getStatus()))
                .map(this::mapToResponse);
    }

    @Override
    public Flux<TeacherCoursesClassroomResponse> findByTeacherId(String teacherId) {
        return repository.findByTeacherId(teacherId)
                .filter(tcc -> "A".equals(tcc.getStatus()))
                .map(this::mapToResponse);
    }

    @Override
    public Mono<TeacherCoursesClassroomResponse> create(TeacherCoursesClassroomRequest request) {
        TeacherCoursesClassroom tcc = new TeacherCoursesClassroom();
        tcc.setTeacherId(request.getTeacherId());
        tcc.setCoursesId(request.getCoursesId());
        tcc.setClassroomId(request.getClassroomId());
        tcc.setStatus("A"); // Default to Active
        return repository.save(tcc)
                .map(this::mapToResponse);
    }

    @Override
    public Mono<TeacherCoursesClassroomResponse> update(String id, TeacherCoursesClassroomRequest request) {
        return repository.findById(id)
                .filter(tcc -> "A".equals(tcc.getStatus()))
                .flatMap(existing -> {
                    if (request.getTeacherId() != null) {
                        existing.setTeacherId(request.getTeacherId());
                    }
                    if (request.getCoursesId() != null) {
                        existing.setCoursesId(request.getCoursesId());
                    }
                    if (request.getClassroomId() != null) {
                        existing.setClassroomId(request.getClassroomId());
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
                .filter(tcc -> "A".equals(tcc.getStatus()))
                .flatMap(tcc -> {
                    tcc.setStatus("I");
                    return repository.save(tcc).then();
                });
    }

    private TeacherCoursesClassroomResponse mapToResponse(TeacherCoursesClassroom tcc) {
        TeacherCoursesClassroomResponse response = new TeacherCoursesClassroomResponse();
        response.setId(tcc.getId());
        response.setTeacherId(tcc.getTeacherId());
        response.setCoursesId(tcc.getCoursesId());
        response.setClassroomId(tcc.getClassroomId());
        response.setStatus(tcc.getStatus());
        return response;
    }
}