package ru.otus.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.dto.HealthDto;
import ru.otus.service.HealthService;

@Service
public class HealthServiceImpl implements HealthService {

    public HealthDto getStatus() {
        return new HealthDto("OK");
    }

}
