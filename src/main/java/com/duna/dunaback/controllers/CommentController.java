package com.duna.dunaback.controllers;

import com.duna.dunaback.dtos.CommentDtoIn;
import com.duna.dunaback.dtos.CommentDtoOut;
import com.duna.dunaback.dtos.CommentMiniDtoOut;
import com.duna.dunaback.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/secured/comment")
    public CommentDtoOut addComment(@RequestBody @Valid CommentDtoIn commentDtoIn, Principal principal) {
        return commentService.addComment(commentDtoIn, principal);
    }

    @GetMapping("/comments/mini/{id}")
    public List<CommentMiniDtoOut> getAllMiniCommentsByAddresseeId(@PathVariable Long id) {
        return commentService.getAllMiniCommentsByAddresseeId(id);
    }

    @GetMapping("/comments/{id}")
    public List<CommentDtoOut> getAllCommentsByAddresseeId(@PathVariable Long id) {
        return commentService.getAllCommentsByAddresseeId(id);
    }

    //test endpoints
    @PostMapping("/comment")
    public String testComment(@RequestBody @Valid CommentDtoIn commentDtoIn) {
        return commentDtoIn.getText();
    }

}
