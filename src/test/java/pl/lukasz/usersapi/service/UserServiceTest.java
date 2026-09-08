package pl.lukasz.usersapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.lukasz.usersapi.dto.CreateUserRequest;
import pl.lukasz.usersapi.dto.UserResponse;
import pl.lukasz.usersapi.entity.AppUser;
import pl.lukasz.usersapi.mapper.UserMapper;
import pl.lukasz.usersapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    void getUserById() {
        Long userId = 1L;

        AppUser mockUser = new AppUser();
        mockUser.setId(userId);
        mockUser.setFirstName("Lukasz");

        UserResponse mockResponse = new UserResponse();
        mockResponse.setId(userId);
        mockResponse.setFirstName("Lukasz");

        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));
        when(userMapper.toResponse(mockUser)).thenReturn(mockResponse);

        UserResponse result = userService.getUserById(userId);

        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals("Lukasz",  result.getFirstName());
    }

    @Test
    void createUser() {
        CreateUserRequest request = new CreateUserRequest();
        request.setFirstName("Lukasz");
        request.setLastName("Kacz");
        request.setEmail("kacz@test.com");

        AppUser mockUser = new AppUser();
        mockUser.setFirstName("Lukasz");

        AppUser savedMockuser = new AppUser();
        savedMockuser.setId(5L);
        savedMockuser.setFirstName("Lukasz");

        UserResponse mockResponse = new UserResponse();
        mockResponse.setId(5L);
        mockResponse.setFirstName("Lukasz");

        when(userMapper.toEntity(request)).thenReturn(mockUser);
        when(userRepository.save(mockUser)).thenReturn(savedMockuser);
        when(userMapper.toResponse(savedMockuser)).thenReturn(mockResponse);

        UserResponse result = userService.createUser(request);

        assertNotNull(result);
        assertEquals(5L, result.getId());
        assertEquals("Lukasz", result.getFirstName());
    }

    @Test
    void getAllUsers() {
        AppUser mockUser = new AppUser();
        mockUser.setFirstName("Kamil");

        AppUser savedMockuser = new AppUser();
        savedMockuser.setId(5L);
        savedMockuser.setFirstName("Kamil");

        UserResponse mockResponse = new UserResponse();
        mockResponse.setId(5L);
        mockResponse.setFirstName("Kamil");

        when(userRepository.findAll()).thenReturn(List.of(savedMockuser));
        when(userMapper.toResponse(savedMockuser)).thenReturn(mockResponse);

        List<UserResponse> result = userService.getAllUsers();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Kamil", result.get(0).getFirstName());

    }

    @Test
    void updateUser() {
        Long id  = 1L;
        AppUser mockUser = new AppUser();
        mockUser.setId(id);
        mockUser.setFirstName("Lukasz");

        UserResponse mockResponse = new UserResponse();
        mockResponse.setId(id);
        mockResponse.setFirstName("Lukasz");

        AppUser savedMockuser = new AppUser();
        savedMockuser.setId(id);
        savedMockuser.setFirstName("Lukasz");

        CreateUserRequest request = new CreateUserRequest();
        request.setFirstName("Lukasz");
        request.setLastName("Kacz");
        request.setEmail("kacz@test.com");

        when(userRepository.findById(id)).thenReturn(Optional.of(mockUser));
        when(userRepository.save(mockUser)).thenReturn(savedMockuser);
        when(userMapper.toResponse(savedMockuser)).thenReturn(mockResponse);

        UserResponse result = userService.updateUser(id, request);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Lukasz", result.getFirstName());
    }


    @Test
    void deleteUser() {
        // Arrange
        Long userId = 1L;

        // Act
        userService.deleteUser(userId);

        // Assert
        org.mockito.Mockito.verify(userRepository, org.mockito.Mockito.times(1)).deleteById(userId);
    }
}
