package com.trinhpokemon.managelibrary.controller;

import com.trinhpokemon.managelibrary.dto.request.User.request.UserCreationRequest;
import com.trinhpokemon.managelibrary.dto.request.User.request.UserUpdateRequest;
import com.trinhpokemon.managelibrary.dto.request.User.response.UserResponse;
import com.trinhpokemon.managelibrary.entity.User;
import com.trinhpokemon.managelibrary.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @GetMapping
    public Page<UserResponse> getAllUsers(@RequestParam(value = "search", required = false) String searchValue, Pageable pageable) {
        return userService.getUsers(searchValue, pageable);
    }

    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
    }
}
