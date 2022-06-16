package com.kamal.getmesocial.resources;

import com.google.firebase.auth.FirebaseAuthException;
import com.kamal.getmesocial.exception.IdTokenException;
import com.kamal.getmesocial.model.FirebaseUser;
import com.kamal.getmesocial.model.MongoComment;
import com.kamal.getmesocial.model.MongoPhoto;
import com.kamal.getmesocial.model.MongoUser;
import com.kamal.getmesocial.service.FirebaseAdminService;
import com.kamal.getmesocial.service.MongoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MongoCommentResource {
    @Autowired
    private MongoCommentService mongoCommentService;

    @Autowired
    private FirebaseAdminService firebaseAdminService;

    @PostMapping("/comment")
    public MongoComment createComment(@RequestBody @Valid MongoComment mongoComment, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, IdTokenException {
        FirebaseUser fcomment = firebaseAdminService.authentication(idToken);
        if(fcomment != null){
            mongoCommentService.createComment(mongoComment, fcomment.getName());
            return mongoComment;
        }else {
            return null;
        }

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
    public MongoComment updateComment(@RequestBody MongoComment mongoComment, @RequestHeader(name = "idToken") String idToken) throws Exception {
        FirebaseUser fcomment = firebaseAdminService.authentication(idToken);
        if(fcomment != null){
            String user = mongoComment.getCreatedBy();
            if(fcomment.getName().equals(user)){
                return mongoCommentService.updateComment(mongoComment);
            }else{
                throw new Exception("WRONG USER");
            }
        }else {
            return null;
        }

    }

    @DeleteMapping("/comment")
    public void deleteMongoComment(@RequestParam(name = "id") String commentId, @RequestHeader(name = "idToken") String idToken) throws Exception {
        FirebaseUser fcomment = firebaseAdminService.authentication(idToken);
        if(fcomment != null){
            mongoCommentService.deleteComment(commentId, fcomment.getName());
        }

    }


}
