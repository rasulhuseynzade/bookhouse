package com.example.bookhouse.mapper;

import com.example.bookhouse.dao.AuthorEntity;
import com.example.bookhouse.dao.BookEntity;
import com.example.bookhouse.model.AuthorViewDto;
import com.example.bookhouse.model.BookViewDto;;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "comments", target = "comments")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "meetings", target = "meetings")
    @Mapping(source = "author" ,target = "author")

    BookViewDto entityToDto(BookEntity bookEntity);
    BookEntity dtoToEntity(BookViewDto bookViewDto);
    BookEntity dtoToEntity(Long id, BookViewDto bookViewDto);
}
