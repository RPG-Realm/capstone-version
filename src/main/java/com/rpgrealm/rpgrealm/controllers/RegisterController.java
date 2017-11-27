/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.User;
import com.rpgrealm.rpgrealm.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {

    private final UserRepository usrRep;

    public RegisterController(UserRepository usrRep){

        this.usrRep=usrRep;
    }

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

//        this should not be hardcoded in production
        user.setUser_created_time("0");
        usrRep.save(user);


        return "redirect:/login";
    }
}
