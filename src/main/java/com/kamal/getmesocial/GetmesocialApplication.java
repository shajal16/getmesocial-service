package com.kamal.getmesocial;

import com.kamal.getmesocial.repository.MongoUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class GetmesocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetmesocialApplication.class, args);
	}
}
