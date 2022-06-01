package com.kamal.getmesocial.repository;



import com.kamal.getmesocial.model.MongoComment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoCommentRepository extends MongoRepository<MongoComment, String>  {

}
