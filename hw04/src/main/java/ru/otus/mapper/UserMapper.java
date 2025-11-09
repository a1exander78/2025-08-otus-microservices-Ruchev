package ru.otus.mapper;

import org.mapstruct.Mapper;
import ru.otus.dto.UserDto;
import ru.otus.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto userDto);

}
