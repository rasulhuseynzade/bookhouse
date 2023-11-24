package com.example.bookhouse.controller;

import com.example.bookhouse.model.ComicsViewDto;
import com.example.bookhouse.service.ComicsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book_house/comics")
@RequiredArgsConstructor
public class ComicsController {
    private final ComicsService comicsService;
    @GetMapping
    public List<ComicsViewDto> getComicsList(){
        return comicsService.getComicsList();
    }
    @PostMapping()
    public void addComics(@RequestBody @Valid ComicsViewDto comicsViewDto){
        comicsService.addComics(comicsViewDto);

    }
    @PutMapping("/{comicsId}")
    public void updateComics(
            @PathVariable Long comicsId,
            @RequestBody ComicsViewDto comicsViewDto
    ) {
        comicsService.updateComics(comicsId, comicsViewDto);
    }
    @DeleteMapping("/{comicsId}")
    public void deleteComics(@PathVariable Long comicsId){
        comicsService.deleteComics(comicsId);

    }
    @GetMapping("/{comicsId}")
    public ComicsViewDto getComics(@PathVariable Long comicsId){
        return comicsService.getComics(comicsId);
    }
}
