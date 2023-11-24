package com.example.bookhouse.controller;

import com.example.bookhouse.model.UserDto;
import com.example.bookhouse.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/registrate")
    public void registrate(@RequestBody @Valid UserDto userDto) {
        userService.registrate(userDto);

    }
}
