package pe.edu.vallegrande.vgmsadacemic.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.request.TeacherCoursesClassroomRequest;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.response.TeacherCoursesClassroomResponse;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.service.TeacherCoursesClassroomService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/teacher-courses-classroom")
@RequiredArgsConstructor
public class TeacherCoursesClassroomRest {

    private final TeacherCoursesClassroomService service;

    @GetMapping
    public Flux<TeacherCoursesClassroomResponse> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<TeacherCoursesClassroomResponse> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/teacher/{teacherId}")
    public Flux<TeacherCoursesClassroomResponse> getByTeacherId(@PathVariable String teacherId) {
        return service.findByTeacherId(teacherId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TeacherCoursesClassroomResponse> create(@RequestBody TeacherCoursesClassroomRequest request) {
        return service.create(request);
    }

    @PatchMapping("/{id}")
    public Mono<TeacherCoursesClassroomResponse> update(@PathVariable String id, @RequestBody TeacherCoursesClassroomRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}