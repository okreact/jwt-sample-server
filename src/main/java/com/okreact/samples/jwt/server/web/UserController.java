package com.okreact.samples.jwt.server.web;

import com.okreact.samples.jwt.server.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {


    @GetMapping("/users")
    public List<User> getUsers() {

        return Arrays.asList(User.builder().firstName("Richard").lastName("Feynman").build(),
                User.builder().firstName("Grigori").lastName("Perelman").build());
    }

}
