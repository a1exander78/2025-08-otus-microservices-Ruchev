package ru.otus.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.dto.UserDto;
import ru.otus.dto.UserRequestDto;
import ru.otus.exception.UserNotFoundException;
import ru.otus.mapper.UserMapper;
import ru.otus.model.User;
import ru.otus.repository.UserRepository;
import ru.otus.service.UserService;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserDto findUserById(Long id) {
        return userRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new UserNotFoundException("User with id %d not found".formatted(id)));
    }

    public UserDto saveUser(Long id, UserRequestDto request) {
        var user = save(id, request);
        return mapper.toDto(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    private User save(Long id, UserRequestDto request) {
        var user = User.builder()
                .username(request.username())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .build();
        if (!isNull(id)) {
            user.setId(id);
        }
        return userRepository.save(user);
    }

}
