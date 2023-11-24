package com.example.bookhouse.mapper;

import com.example.bookhouse.dao.ComicsEntity;
import com.example.bookhouse.model.ComicsViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComicsMapper {

    ComicsViewDto entityToDto(ComicsEntity comicsEntity);
    ComicsEntity dtoToEntity(ComicsViewDto comicsViewDto);
    @Mapping(target = "id", source = "id")
    ComicsEntity dtoToEntity(Long id, ComicsViewDto comicsViewDto);
}
