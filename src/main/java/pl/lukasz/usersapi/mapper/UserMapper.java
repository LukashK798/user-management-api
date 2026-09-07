package pl.lukasz.usersapi.mapper;

import org.apache.catalina.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import pl.lukasz.usersapi.dto.CreateUserRequest;
import pl.lukasz.usersapi.dto.UserResponse;
import pl.lukasz.usersapi.entity.AppUser;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toResponse(AppUser appUser);
    AppUser toEntity(CreateUserRequest request);

    void updateEntity(CreateUserRequest request, @MappingTarget AppUser entity);
}
