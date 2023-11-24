package com.example.bookhouse.mapper;

import com.example.bookhouse.dao.CommentEntity;
import com.example.bookhouse.model.CommentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentEntity dtoToEntity(CommentDto commentDto);

    CommentDto entityToDto(CommentEntity commentEntity);

}
