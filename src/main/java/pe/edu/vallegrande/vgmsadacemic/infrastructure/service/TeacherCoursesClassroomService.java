package pe.edu.vallegrande.vgmsadacemic.infrastructure.service;

import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.request.TeacherCoursesClassroomRequest;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.response.TeacherCoursesClassroomResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeacherCoursesClassroomService {

    Flux<TeacherCoursesClassroomResponse> findAll();

    Mono<TeacherCoursesClassroomResponse> findById(String id);

    Flux<TeacherCoursesClassroomResponse> findByTeacherId(String teacherId);

    Mono<TeacherCoursesClassroomResponse> create(TeacherCoursesClassroomRequest request);

    Mono<TeacherCoursesClassroomResponse> update(String id, TeacherCoursesClassroomRequest request);

    Mono<Void> delete(String id);
}