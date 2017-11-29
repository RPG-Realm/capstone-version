/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.User;
import com.rpgrealm.rpgrealm.repositories.Users;
import org.hibernate.validator.constraints.ModCheck;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {
  private final Users usrRep;
  private PasswordEncoder passwordEncoder;

  public UsersController(Users usrRep, PasswordEncoder passwordEncoder)
  {
    this.usrRep=usrRep;
    this.passwordEncoder=passwordEncoder;
  }

  @GetMapping("/sign-up")
  public String showSignupForm(Model model){
    model.addAttribute("user", new User());
    return "users/sign-up";
  }

  @PostMapping("/sign-up")
  public String saveUser(@ModelAttribute User user){
    String hash = passwordEncoder.encode(user.getPassword());
    user.setPassword(hash);
    user.setUser_created_time("0");
    usrRep.save(user);
    return "redirect:/login";
  }

  @GetMapping("/user-profile")
  public String showUser(Model model) {
    User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    model.addAttribute("user", user);
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