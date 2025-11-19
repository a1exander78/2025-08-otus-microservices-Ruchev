package ru.otus.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.dto.HealthDto;
import ru.otus.service.HealthService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class HealthController {
    private final HealthService healthService;

    @GetMapping({"/health/", "/health"})
    public HealthDto getStatus() {
        log.info("Request processing...");
        return healthService.getStatus();
    }

}
