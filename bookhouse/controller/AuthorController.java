package com.example.bookhouse.controller;

import com.example.bookhouse.model.AuthorViewDto;
import com.example.bookhouse.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book_house/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    @GetMapping
    public List<AuthorViewDto>getAuthorList(){
        return authorService.getAuthorList();
    }
    @PostMapping
    public void addAuthor(@RequestBody @Valid AuthorViewDto authorViewDto){
        authorService.addAuthor(authorViewDto);
    }
    @PatchMapping("/authorId")
    public void updateAuthor(
            @PathVariable Long authorId,
            @RequestBody AuthorViewDto authorViewDto
    ) {
        authorService.updateAuthor(authorId, authorViewDto);
    }
    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId){
        authorService.deleteAuthor(authorId);
    }
    @GetMapping("/{authorId}")
    public AuthorViewDto getAuthor(@PathVariable Long authorId){
       return authorService.getAuthor(authorId);
    }
}
