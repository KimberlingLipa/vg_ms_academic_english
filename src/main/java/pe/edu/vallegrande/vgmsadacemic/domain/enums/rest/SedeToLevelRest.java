package pe.edu.vallegrande.vgmsadacemic.domain.enums.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vgmsadacemic.domain.enums.SedeToLevel;
import pe.edu.vallegrande.vgmsadacemic.application.service.SedeToLevelService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/sede-to-level")
@RequiredArgsConstructor
public class SedeToLevelRest {

    private final SedeToLevelService service;

    @GetMapping
    public Flux<SedeToLevel> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<SedeToLevel> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/sede/{sedeId}")
    public Flux<SedeToLevel> getBySedeId(@PathVariable String sedeId) {
        return service.findBySedeId(sedeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<SedeToLevel> create(@RequestBody SedeToLevel sedeToLevel) {
        return service.create(sedeToLevel);
    }

    @PatchMapping("/{id}")
    public Mono<SedeToLevel> update(@PathVariable String id, @RequestBody SedeToLevel sedeToLevel) {
        return service.update(id, sedeToLevel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
