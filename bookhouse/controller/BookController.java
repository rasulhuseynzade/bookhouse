package com.example.bookhouse.controller;

import com.example.bookhouse.model.BookViewDto;
import com.example.bookhouse.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book_house/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public Page<BookViewDto> getBookList(Pageable pageable) {

        return bookService.getBookList(pageable);
    }

    @PostMapping
    public void addBook(@RequestBody @Valid BookViewDto bookViewDto) {

        bookService.addBook(bookViewDto);
    }

    @PutMapping("/{bookId}")
    public void updateBook(
            @PathVariable Long bookId,
            @RequestBody BookViewDto bookViewDto
    ) {
        bookService.updateBook(bookId, bookViewDto);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
       bookService.deleteBook(bookId);

    }

    @GetMapping("/{bookId}")
    public BookViewDto getBook(@PathVariable Long bookId) {

        return bookService.getBook(bookId);
    }
}

