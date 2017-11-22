/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {


//    private PasswordEncoder encoder;
//    private UsersRepository repository;
//
//    public UsersController(PasswordEncoder encoder, UsersRepository repository) {
//        this.encoder = encoder;
//        this.repository = repository;
//    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        // TODO: Validate the input
        // TODO: double check that the username is not already in use

//        String hash = encoder.encode(user.getPassword());
//        user.setPassword(hash);
//        repository.save(user);

        return "/login";
    }
}
