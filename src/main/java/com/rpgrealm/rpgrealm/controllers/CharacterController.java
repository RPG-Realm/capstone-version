/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharacterController {
  @GetMapping("/create_character")
  public String createCharacter() {
    return "create_character";
  }

  @GetMapping("/view_character")
  public String viewCharacter() {
    return "view_character";
  }

  @GetMapping("/edit_character")
  public String editCharacter() {
    return "edit_character";
  }

}

