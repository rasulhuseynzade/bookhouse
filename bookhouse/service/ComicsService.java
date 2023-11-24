package com.example.bookhouse.service;

import com.example.bookhouse.mapper.ComicsMapper;
import com.example.bookhouse.model.ComicsViewDto;
import com.example.bookhouse.repository.ComicsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComicsService {
    private final ComicsRepository comicsRepository;
    private final ComicsMapper comicsMapper;

    public List<ComicsViewDto> getComicsList(){
        var comicsEntityList = comicsRepository.findAll();
        return comicsEntityList.stream()
                .map(comicsMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void addComics(ComicsViewDto comicsViewDto){
        var comicsEntity = comicsMapper.dtoToEntity(comicsViewDto);
        comicsRepository.save(comicsEntity);
        
    }
    public void updateComics(Long comicsId, ComicsViewDto comicsViewDto){
        var comicsEntity = comicsMapper.dtoToEntity(comicsId, comicsViewDto);
        comicsRepository.save(comicsEntity);

    }
    public void deleteComics(Long comicsId){
        comicsRepository.deleteById(comicsId);
    }
    public ComicsViewDto getComics(Long comicsId){
        var comicsEntity = comicsRepository.findById(comicsId).orElseThrow(
                () -> new RuntimeException("COMICS_NOT_FOUND")
        );
        return comicsMapper.entityToDto(comicsEntity);
    }
}
