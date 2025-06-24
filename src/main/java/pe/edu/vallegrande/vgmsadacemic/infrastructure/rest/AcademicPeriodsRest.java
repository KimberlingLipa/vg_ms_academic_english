package pe.edu.vallegrande.vgmsadacemic.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.request.AcademicPeriodsRequest;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.dto.response.AcademicPeriodsResponse;
import pe.edu.vallegrande.vgmsadacemic.infrastructure.service.AcademicPeriodsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/academic-periods")
@RequiredArgsConstructor
public class AcademicPeriodsRest {

    private final AcademicPeriodsService service;

    @GetMapping
    public Flux<AcademicPeriodsResponse> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<AcademicPeriodsResponse> getById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/institution/{institutionId}")
    public Flux<AcademicPeriodsResponse> getByInstitutionId(@PathVariable String institutionId) {
        return service.findByInstitutionId(institutionId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AcademicPeriodsResponse> create(@RequestBody AcademicPeriodsRequest request) {
        return service.create(request);
    }

    @PatchMapping("/{id}")
    public Mono<AcademicPeriodsResponse> update(@PathVariable String id, @RequestBody AcademicPeriodsRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}