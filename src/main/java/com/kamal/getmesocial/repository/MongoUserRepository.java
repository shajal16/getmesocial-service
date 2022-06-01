package com.kamal.getmesocial.repository;


import com.kamal.getmesocial.model.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<MongoUser, String>  {

}
