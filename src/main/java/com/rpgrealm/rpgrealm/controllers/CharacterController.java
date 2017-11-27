/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.Character;
import com.rpgrealm.rpgrealm.repositories.CharacterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CharacterController {

  private final CharacterRepository charRep;

  public CharacterController(CharacterRepository charRep) {
    this.charRep = charRep;
  }

  @GetMapping("/create-character")
  public String showCharacterForm(Model model) {
    model.addAttribute("character", new Character());
    return "create-character";
  }

  @PostMapping("/create-character")
  public String createCharacter(@ModelAttribute Character character) {
    charRep.save(character);
    return "redirect:/view-character";
  }

  @GetMapping("/view-character")
  public String viewCharacter(Model model) {
    model.addAttribute("character", new Character());
    return "view-character";
  }

  @GetMapping("/edit-character")
  public String showEditCharacterForm(Model model) {
    model.addAttribute("character", new Character());
    return "view-character";
  }

  @PostMapping("/edit-character")
  public String editCharacter(@ModelAttribute Character character) {
    return "view-character";
  }

}

