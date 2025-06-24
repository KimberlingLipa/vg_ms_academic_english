package pe.edu.vallegrande.vgmsadacemic.domain.enums.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vgmsadacemic.domain.enums.Courses;
import pe.edu.vallegrande.vgmsadacemic.application.service.CoursesService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CoursesRest {

    private final CoursesService service;

    @GetMapping
    public Flux<Courses> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Courses> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/institution/{institutionId}")
    public Flux<Courses> getByInstitutionId(@PathVariable String institutionId) {
        return service.findByInstitutionId(institutionId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Courses> create(@RequestBody Courses course) {
        return service.create(course);
    }

    @PatchMapping("/{id}")
    public Mono<Courses> update(@PathVariable String id, @RequestBody Courses course) {
        return service.update(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
