package ru.otus.service;

import org.springframework.stereotype.Service;
import ru.otus.dto.HealthDto;

@Service
public class HealthServiceImpl implements HealthService {

    public HealthDto getStatus() {
        return new HealthDto("OK");
    }

}
