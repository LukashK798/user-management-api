package pl.lukasz.usersapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pl.lukasz.usersapi.dto.CreateUserRequest;
import pl.lukasz.usersapi.dto.UserResponse;
import pl.lukasz.usersapi.entity.AppUser;
import pl.lukasz.usersapi.exception.ResourceNotFoundException;
import pl.lukasz.usersapi.mapper.UserMapper;
import pl.lukasz.usersapi.repository.UserRepository;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(CreateUserRequest request){
        AppUser user = userMapper.toEntity(request);
        AppUser savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    public Page<UserResponse> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::toResponse);
    }

    public UserResponse getUserById(Long id){
        AppUser user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return userMapper.toResponse(user);
    }

    public UserResponse updateUser(Long id, CreateUserRequest request){

        AppUser user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        userMapper.updateEntity(request,user);
        AppUser savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
