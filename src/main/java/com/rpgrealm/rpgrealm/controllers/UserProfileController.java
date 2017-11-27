/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {
  @GetMapping("/user_profile")
  public String showUserProfile() {
    return "user_profile";


  }

  @GetMapping("/user_profile/edit")
  public String editUserProfile() {
    return "user_profile_edit";
  }
}