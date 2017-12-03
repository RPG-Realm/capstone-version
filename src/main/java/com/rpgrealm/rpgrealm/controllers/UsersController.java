/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.AppFile;
import com.rpgrealm.rpgrealm.models.User;
import com.rpgrealm.rpgrealm.repositories.AppFileRepository;
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
  private final AppFileRepository fileRep;
  private PasswordEncoder passwordEncoder;

  public UsersController(Users usrRep, PasswordEncoder passwordEncoder, AppFileRepository fileRep)
  {
    this.usrRep=usrRep;
    this.passwordEncoder=passwordEncoder;
    this.fileRep = fileRep;
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
    User dbUser=usrRep.findOne(user.getId());
    AppFile profilePhoto= dbUser.getProfile_photo();
    model.addAttribute("user", dbUser);
    model.addAttribute("profilePhoto",profilePhoto);
    return "user-profile";
  }

  @GetMapping("/user-profile/edit")
  public String editUser( Model model) {
    User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User dbUser=usrRep.findOne(user.getId());
    model.addAttribute("user", dbUser);
    return "user-profile-edit";
  }

  @PostMapping("/user-profile/edit")
  public String commitEditUser( @ModelAttribute User user){
    System.out.println(user.getId());
    String hash = passwordEncoder.encode(user.getPassword());
    user.setPassword(hash);
    user.setProfile_photo(user.getProfile_photo());
    usrRep.save(user);
    return "user-profile";
  }
}