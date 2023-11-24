package com.example.bookhouse.service;

import com.example.bookhouse.exception.NotFoundException;
import com.example.bookhouse.repository.BookRepository;
import com.example.bookhouse.repository.CommentRepository;
import com.example.bookhouse.mapper.CommentMapper;
import com.example.bookhouse.model.CommentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    private final CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, BookRepository bookRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
        this.commentMapper = commentMapper;
    }

    public void addComment(CommentDto commentDto) {
        log.info("addComment.start");
        var bookEntity = bookRepository.findById(commentDto.getBookId()).orElseThrow(
                () -> new NotFoundException("BOOK_NOT_FOUND")
        );
        var commentEntity = commentMapper.dtoToEntity(commentDto);

        commentRepository.save(commentEntity);
        log.info("addComment.end");
    }

    public CommentDto getComment(Long commentId) {
        var commentEntity = commentRepository.findById(commentId).orElseThrow(
                () -> new NotFoundException("COMMENT_NOT_FOUND")
        );
        return commentMapper.entityToDto(commentEntity);
    }
}

