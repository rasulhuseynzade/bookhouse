package com.example.bookhouse.service;

import com.example.bookhouse.exception.NotFoundException;
import com.example.bookhouse.mapper.BookMapper;
import com.example.bookhouse.model.BookViewDto;
import com.example.bookhouse.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public Page<BookViewDto> getBookList(Pageable pageable){
        var bookEntityList = bookRepository.findAll(pageable);

        var list = bookEntityList.stream()
                .map(bookMapper::entityToDto)
                .collect(Collectors.toList());

        return new PageImpl<>(list, pageable, pageable.getPageSize());
    }
    public void addBook(BookViewDto bookViewDto){
        var bookEntity = bookMapper.dtoToEntity(bookViewDto);
        bookRepository.save(bookEntity);
    }
    public void updateBook(Long bookId, BookViewDto bookViewDto){
        var bookEntity = bookMapper.dtoToEntity(bookId,bookViewDto);
        bookRepository.save(bookEntity);
    }
    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }
    public BookViewDto getBook(Long bookId){
        var bookEntity = bookRepository.findById(bookId).orElseThrow(
                () -> new NotFoundException("BOOK_NOT_FOUND")
        );
        return bookMapper.entityToDto(bookEntity);


    }
}
