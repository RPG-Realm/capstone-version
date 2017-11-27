/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.Character;
import com.rpgrealm.rpgrealm.repositories.CharacterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharacterController {

  private final CharacterRepository charRep;

  public CharacterController(CharacterRepository charRep) {
    this.charRep = charRep;
  }

  @GetMapping("/create_character")
  public String createCharacter(Model model) {
    model.addAttribute("character",new Character());
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

