package com.kamal.getmesocial.resources;

import com.kamal.getmesocial.model.MongoComment;
import com.kamal.getmesocial.model.MongoPhoto;
import com.kamal.getmesocial.model.MongoUser;
import com.kamal.getmesocial.service.MongoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MongoCommentResource {
    @Autowired
    private MongoCommentService mongoCommentService;

    @PostMapping("/comment")
    public MongoComment createComment(@RequestBody @Valid MongoComment mongoComment){
        mongoCommentService.createComment(mongoComment);
        return mongoComment;
    }
    @GetMapping("/comments")
    public List<MongoComment> getAllComments() {
        return mongoCommentService.getAllComments();

    }

    @GetMapping("/comment")
    public Optional<MongoComment> getById(@RequestParam (name = "id") String id) {
        return mongoCommentService.getById(id);

    }
    @PutMapping("/comment")
    public MongoComment updateComment(@RequestBody MongoComment mongoComment){
        return mongoCommentService.updateComment(mongoComment);

    }

    @DeleteMapping("/comment")
    public void deleteMongoComment(@RequestParam(name = "id") String commentId) {
        mongoCommentService.deleteComment(commentId);

    }


}
