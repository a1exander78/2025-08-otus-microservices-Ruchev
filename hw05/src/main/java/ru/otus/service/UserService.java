package ru.otus.service;

import ru.otus.dto.UserDto;
import ru.otus.dto.UserRequestDto;

public interface UserService {
    UserDto findUserById(Long id);
    UserDto saveUser(Long id, UserRequestDto request);
    void deleteUserById(Long id);

}
