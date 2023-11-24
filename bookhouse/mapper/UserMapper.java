package com.example.bookhouse.mapper;

import com.example.bookhouse.dao.security.UserEntity;
import com.example.bookhouse.model.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto entityToDto(UserEntity userEntity);

}
