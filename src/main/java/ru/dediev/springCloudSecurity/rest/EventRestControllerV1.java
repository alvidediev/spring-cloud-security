package ru.dediev.springCloudSecurity.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dediev.springCloudSecurity.exception.UserNotFoundInBaseException;
import ru.dediev.springCloudSecurity.model.entity.EventEntity;
import ru.dediev.springCloudSecurity.service.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/events")
@Api(
        value = "API for uploading/downloading history",
        description = "Controller for getting history of downloading, uploading files",
        produces = "application/json"
)
public class EventRestControllerV1 {

    private final EventService service;

    @GetMapping("/{id}")
    public Optional<EventEntity> getById(
            @ApiParam("Param (Long) to get event by id")
            @PathVariable Long id
    ) throws UserNotFoundInBaseException {
        return service.getById(id);
    }

    @GetMapping
    public List<EventEntity> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
        } catch (UserNotFoundInBaseException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("User deleted");
    }
}
