package com.kamal.getmesocial.repository;


import com.kamal.getmesocial.model.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoUserRepository extends MongoRepository<MongoUser, String>  {

    List<MongoUser> findByName(String name);
}
