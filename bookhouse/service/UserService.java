package com.example.bookhouse.service;

import com.example.bookhouse.dao.security.AuthorityEntity;
import com.example.bookhouse.dao.security.UserEntity;
import com.example.bookhouse.model.UserDto;
import com.example.bookhouse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registrate(UserDto userDto) {
        var user = UserEntity.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .enabled(true)
                .build();

        List<AuthorityEntity> authorityEntityList = new ArrayList<>();

        userDto.getRoleList().forEach(
                role -> authorityEntityList.add(new AuthorityEntity(null, user, role.name()))

                );



        user.setAuthorityEntityList(authorityEntityList);

        userRepository.save(user);


    }
}
