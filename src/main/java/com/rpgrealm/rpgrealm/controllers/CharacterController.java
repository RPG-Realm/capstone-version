/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.Character;
import com.rpgrealm.rpgrealm.repositories.CharacterRepository;
import com.rpgrealm.rpgrealm.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CharacterController {

  private final CharacterRepository charRep;
  private final UserRepository usrRep;

  public CharacterController(CharacterRepository charRep, UserRepository usrRep) {
    this.charRep = charRep;
    this.usrRep = usrRep;
  }

  @GetMapping("/create-character")
  public String showCharacterForm(Model model) {
    model.addAttribute("character", new Character());
    return "create-character";
  }

  @PostMapping("/create-character")
  public String createCharacter(@ModelAttribute Character character) {
    character.setPlayer(usrRep.findOne(1L));
    charRep.save(character);
    return "redirect:/view-character";
  }

  @GetMapping("/view-character/{id}")
  public String viewCharacter(Model model, @PathVariable Long id) {
    model.addAttribute("character", charRep.findOne(id));
    return "view-character";
  }

  @GetMapping("/edit-character/{id}")
  public String showEditCharacterForm(Model model, @PathVariable Long id) {
    model.addAttribute("character", new Character());
    return "view-character";
  }

  @PostMapping("/edit-character/{id}")
  public String editCharacter(@ModelAttribute Character character) {
    charRep.save(character);
    return "view-character";
  }

}

