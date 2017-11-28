/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.User;
import com.rpgrealm.rpgrealm.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
  private final UserRepository usrRep;

  public UserController(UserRepository usrRep){
    this.usrRep=usrRep;
  }

  @GetMapping("/user-profile")
  public String showUser(Model model) {
    model.addAttribute("user", usrRep.findOne(1L));
    return "user-profile";
  }

  @GetMapping("/user-profile/edit/{id}")
  public String editUser(@PathVariable Long id, User user) {

    return "user-profile-edit";
  }
}