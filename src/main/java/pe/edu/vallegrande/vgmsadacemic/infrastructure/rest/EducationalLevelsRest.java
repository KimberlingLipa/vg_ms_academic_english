package pe.edu.vallegrande.vgmsadacemic.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.request.EducationalLevelsRequest;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.response.EducationalLevelsResponse;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.service.EducationalLevelsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/educational-levels")
@RequiredArgsConstructor
public class EducationalLevelsRest {

    private final EducationalLevelsService service;

    @GetMapping
    public Flux<EducationalLevelsResponse> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<EducationalLevelsResponse> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/code/{levelCode}")
    public Mono<EducationalLevelsResponse> getByLevelCode(@PathVariable String levelCode) {
        return service.findByLevelCode(levelCode);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<EducationalLevelsResponse> create(@RequestBody EducationalLevelsRequest request) {
        return service.create(request);
    }

    @PatchMapping("/{id}")
    public Mono<EducationalLevelsResponse> update(@PathVariable String id, @RequestBody EducationalLevelsRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}