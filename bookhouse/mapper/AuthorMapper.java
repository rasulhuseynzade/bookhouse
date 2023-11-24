package com.example.bookhouse.mapper;

import com.example.bookhouse.dao.AuthorEntity;
import com.example.bookhouse.model.AuthorViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(source = "name", target = "name")
    AuthorViewDto entityToDto(AuthorEntity authorEntity);
    AuthorEntity dtoToEntity(AuthorViewDto authorViewDto);
    AuthorEntity dtoToEntity(Long id, AuthorViewDto authorViewDto);


}


