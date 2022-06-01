package com.kamal.getmesocial.repository;


import com.kamal.getmesocial.model.MongoPhoto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoPhotoRepository extends MongoRepository<MongoPhoto, String>  {

}
