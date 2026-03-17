package com.example.demo.service.impl;

import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.exception.user.UserAlreadyExistsException;
import com.example.demo.exception.user.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {

        if(userRepository.existsByEmail(userRequest.getEmail()))
        {
            throw new UserAlreadyExistsException("This account already exist!!!");
        }

        User user = UserMapper.mapToUser(userRequest);
        User savedUser = userRepository.save(user);

        return UserMapper.mapToUserResponse(savedUser);
    }

    @Override
    public UserResponse getUserById(UUID id) {
        User foundUser = userRepository
                .findByPublicId(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found!!!"));

        return UserMapper.mapToUserResponse(foundUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserResponse> allUsers = userRepository.findAll()
                .stream()
                .map(UserMapper::mapToUserResponse)
                .toList();

        return  allUsers;

    }
}
