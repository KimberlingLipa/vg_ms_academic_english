package pe.edu.vallegrande.vgmsadacemic.domain.enums.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vgmsadacemic.domain.enums.Classrooms;
import pe.edu.vallegrande.vgmsadacemic.application.service.ClassroomsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/classrooms")
@RequiredArgsConstructor
public class ClassroomsRest {

    private final ClassroomsService service;

    @GetMapping
    public Flux<Classrooms> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Classrooms> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/sede/{sedeId}")
    public Flux<Classrooms> getBySedeId(@PathVariable String sedeId) {
        return service.findBySedeId(sedeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Classrooms> create(@RequestBody Classrooms classroom) {
        return service.create(classroom);
    }

    @PatchMapping("/{id}")
    public Mono<Classrooms> update(@PathVariable String id, @RequestBody Classrooms classroom) {
        return service.update(id, classroom);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
