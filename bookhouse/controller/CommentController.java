package com.example.bookhouse.controller;

import com.example.bookhouse.model.CommentDto;
import com.example.bookhouse.service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping
    public void addComment(@RequestBody @Valid CommentDto commentDto) {
        commentService.addComment(commentDto);
    }
    @GetMapping("/{commentId}")
        public CommentDto getComment(@PathVariable Long commentId){
        return commentService.getComment(commentId);
        }
    }