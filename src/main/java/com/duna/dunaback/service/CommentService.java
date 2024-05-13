package com.duna.dunaback.service;

import com.duna.dunaback.dtos.CommentDtoIn;
import com.duna.dunaback.dtos.CommentDtoOut;
import com.duna.dunaback.dtos.CommentMiniDtoOut;
import com.duna.dunaback.entities.AppComment;
import com.duna.dunaback.entities.User;
import com.duna.dunaback.exceptions.authreg.WrongUserActionsException;
import com.duna.dunaback.exceptions.comments.CommentException;
import com.duna.dunaback.repositories.CommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepo commentRepo;
    @Autowired
    private UserService userService;

    public CommentDtoOut addComment(CommentDtoIn dtoIn, Principal principal) {
        userCheck(dtoIn.getAuthorId(), principal);
        commentSingletonCheck(dtoIn.getAuthorId(), dtoIn.getAddresseeId());
        AppComment appComment = commentRepo.save(makeComment(dtoIn));
        return makeCommentOut(appComment);
    }

    public List<CommentMiniDtoOut> getAllMiniCommentsByAddresseeId(Long addresseeId) {
        return commentRepo.findAllByAddresseeIdOrderByCreatedAt(addresseeId).stream().
                map(this::makeMiniComment).collect(Collectors.toList());
    }

    public List<CommentDtoOut> getAllCommentsByAddresseeId(Long addresseeId) {
        return commentRepo.findAllByAddresseeIdOrderByCreatedAt(addresseeId).stream()
                .map(this::makeCommentOut).collect(Collectors.toList());
    }

    public Double getUserRating(Long userId) {
        return commentRepo.getUserRating(userId);
    }

    public Long getUserRateCount(Long userId) {
        return commentRepo.countByAddresseeId(userId);
    }

    private CommentMiniDtoOut makeMiniComment(AppComment appComment) {
        return new CommentMiniDtoOut(appComment.getAuthorName(), appComment.getRate(),
                appComment.getText(), appComment.getCreatedAt());
    }

    private AppComment makeComment(CommentDtoIn dtoIn) {
        AppComment comment = new AppComment();
        comment.setText(dtoIn.getText());
        comment.setRate(dtoIn.getRate());
        comment.setAuthorId(dtoIn.getAuthorId());
        comment.setAuthorName(userService.getUserById(dtoIn.getAuthorId()).getRealUsername());
        comment.setCreatedAt(LocalDateTime.now());
        comment.setAddresseeId(dtoIn.getAddresseeId());
        return comment;
    }

    private CommentDtoOut makeCommentOut(AppComment comment) {
        CommentDtoOut dtoOut = new CommentDtoOut();
        dtoOut.setId(comment.getId());
        dtoOut.setAuthorId(comment.getAuthorId());
        dtoOut.setText(comment.getText());
        dtoOut.setRate(comment.getRate());
        dtoOut.setAddresseeId(comment.getAddresseeId());
        dtoOut.setAuthorName(comment.getAuthorName());
        return dtoOut;
    }

    private void userCheck(Long userId, Principal principal) {
        User user = userService.getUserByEmail(principal.getName());
        if(!Objects.equals(user.getId(), userId))
            throw new WrongUserActionsException("Placing comment for another user");
    }

    private void commentSingletonCheck(Long authorId, Long addresseeId) {
        if(commentRepo.findByAuthorIdAndAddresseeId(authorId, addresseeId).isPresent())
            throw new CommentException("Author earlier posted comment to addressee");
    }


}
