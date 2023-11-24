package com.example.bookhouse.service;

import com.example.bookhouse.exception.NotFoundException;
import com.example.bookhouse.mapper.AuthorMapper;
import com.example.bookhouse.model.AuthorViewDto;
import com.example.bookhouse.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public List<AuthorViewDto> getAuthorList() {
        var authorEntityList = authorRepository.findAll();
        return authorEntityList.stream()
                .map(authorMapper::entityToDto)
                .collect(Collectors.toList());
        }
        public void addAuthor(AuthorViewDto authorViewDto){
        var authorEntity = authorMapper.dtoToEntity(authorViewDto);
        authorRepository.save(authorEntity);

        }
        public void updateAuthor(Long authorId, AuthorViewDto authorViewDto){
            var authorEntity = authorMapper.dtoToEntity(authorId, authorViewDto);
            authorRepository.save(authorEntity);
        }
        public void deleteAuthor(Long authorId){
        authorRepository.deleteById(authorId);
        }
        public AuthorViewDto getAuthor(Long authorId){
        var authorEntity =  authorRepository.findById(authorId).orElseThrow(
                () -> new NotFoundException("AUTHOR_NOT_FOUND")
        );
        return authorMapper.entityToDto(authorEntity);
        }
    }

