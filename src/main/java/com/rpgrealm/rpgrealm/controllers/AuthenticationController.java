/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.User;
import com.rpgrealm.rpgrealm.repositories.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
    private final Users usrRep;

    public AuthenticationController(Users usrRep){
        this.usrRep=usrRep;
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user){
        boolean userExists=usrRep.findByUsername(user.getUsername())!=null;
        System.out.println(userExists);
        boolean passwordMatch=user.getPassword().equalsIgnoreCase(usrRep.findByUsername(user.getUsername()).getPassword());
        System.out.println(passwordMatch);
        if(userExists&&passwordMatch){
            return "redirect:/profile";
        }else{
            return "/login";
        }
    }
}
