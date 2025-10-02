package com.trinhpokemon.managelibrary.service;

import com.trinhpokemon.managelibrary.dto.request.User.request.UserCreationRequest;
import com.trinhpokemon.managelibrary.dto.request.User.request.UserUpdateRequest;
import com.trinhpokemon.managelibrary.dto.request.User.response.UserResponse;
import com.trinhpokemon.managelibrary.entity.User;
import com.trinhpokemon.managelibrary.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserCreationRequest request) {
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User user = User.builder()
                .name(request.getName())
                .dob(request.getDob())
                .gender(request.getGender())
                .address(request.getAddress())
                .email(request.getEmail())
                .phone(request.getPhone())
                .username(request.getUsername())
                .password(request.getPassword())
                .role(request.getRole())
                .build();

        return userRepository.save(user);
    }

    public Page<UserResponse> getUsers(String searchValue, Pageable pageable) {
        Page<User> list;

        if(searchValue == null || searchValue.isEmpty()) {
            list = userRepository.findAll(pageable);
        } else {
            list = userRepository.search(searchValue, pageable);
        }

        return list.map(user -> {
            return UserResponse.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .dob(user.getDob())
                    .gender(user.getGender())
                    .address(user.getAddress())
                    .email(user.getEmail())
                    .phone(user.getPhone())
                    .username(user.getUsername())
                    .role(user.getRole())
                    .build();
        });
    }

    public UserResponse getUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .dob(user.getDob())
                .gender(user.getGender())
                .address(user.getAddress())
                .email(user.getEmail())
                .phone(user.getPhone())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

    public UserResponse updateUser(String id, UserUpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(request.getName());
        user.setDob(request.getDob());
        user.setGender(request.getGender());
        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        User savedUser = userRepository.save(user);

        return UserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .dob(savedUser.getDob())
                .gender(savedUser.getGender())
                .address(savedUser.getAddress())
                .email(savedUser.getEmail())
                .phone(savedUser.getPhone())
                .username(savedUser.getUsername())
                .role(savedUser.getRole())
                .build();
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
