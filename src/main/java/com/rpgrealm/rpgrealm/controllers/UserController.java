/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.User;
import com.rpgrealm.rpgrealm.repositories.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
  private final Users usrRep;

  public UserController(Users usrRep){
    this.usrRep=usrRep;
  }

  @GetMapping("/user-profile")
  public String showUser(Model model) {
    model.addAttribute("user", usrRep.findOne(1L));
    return "user-profile";
  }

  @GetMapping("/user-profile/edit/{id}")
  public String editUser(@PathVariable Long id, Model model) {
    model.addAttribute("user", usrRep.findOne(id));
    return "user-profile-edit";
  }

  @PostMapping("/user-profile/edit/{id}")
  public String commitEditUser(@PathVariable Long id, User user){
    usrRep.save(user);
    return "user-profile";
  }
}