/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.User;
import com.rpgrealm.rpgrealm.repositories.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final Users usrRep;

    public HomeController(Users usrRep){
        this.usrRep=usrRep;
    }
    @GetMapping("/home")
    public String showHomePage(Model model) {
        try{
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User dbUser=usrRep.findOne(user.getId());
            model.addAttribute("user",dbUser);
            return "home";
        }catch (Exception e){
            return "home";
        }
    }
    @GetMapping("/about-us")
    public String aboutUs(Model model) {
        try{
            User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User dbUser=usrRep.findOne(user.getId());
            model.addAttribute("user",dbUser);
            return "/about-us";
        }catch (Exception e){
            return "/about-us";
        }
    }
}
