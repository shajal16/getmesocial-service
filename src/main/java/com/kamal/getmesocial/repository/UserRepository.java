package com.kamal.getmesocial.repository;

import com.kamal.getmesocial.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User getUser() {
        User user = new User("Kamal", "Toronto", 28, "https://avatars.githubusercontent.com/u/11277764?v=4");
        return user;
    }

}
