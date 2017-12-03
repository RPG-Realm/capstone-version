/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.AppFile;
import com.rpgrealm.rpgrealm.models.Character;
import com.rpgrealm.rpgrealm.models.User;
import com.rpgrealm.rpgrealm.repositories.AppFileRepository;
import com.rpgrealm.rpgrealm.repositories.CharacterRepository;
import com.rpgrealm.rpgrealm.repositories.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CharacterController {

  private final CharacterRepository charRep;
  private final Users usrRep;
  private final AppFileRepository appRep;

  public CharacterController(CharacterRepository charRep, Users usrRep, AppFileRepository appRep) {
    this.charRep = charRep;
    this.usrRep = usrRep;
    this.appRep = appRep;
  }

  @GetMapping("/create-character")
  public String showCharacterForm(Model model) {
    model.addAttribute("character", new Character());
    return "create-character";
  }

  @PostMapping("/create-character")
  public String createCharacter(@ModelAttribute Character character, RedirectAttributes redirectAttributes) {
    User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    character.setUser(user);
    charRep.save(character);
    redirectAttributes.addAttribute("id", character.getId());
//    String idAsString= Long.toString(character.getId());
    return "redirect:/view-character/{id}";
  }

  @GetMapping("/user-character")
    public String viewAllCharacters(Model model){
     User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     User dbUser=usrRep.findOne(user.getId());
//      This needs to refactored by way of appRep
     model.addAttribute("characterList", charRep.findByUserId(user.getId()));
     model.addAttribute("user", dbUser);
     AppFile profilePhoto= dbUser.getProfile_photo();

      return "character-list";
    }

  @GetMapping("/view-character/{id}")
  public String viewCharacter(Model model, @PathVariable String id) {
      Long idAsLong= Long.parseLong(id);
      model.addAttribute("character", charRep.findOne(idAsLong));
    return "view-character";
  }

  @GetMapping("/edit-character/{id}")
  public String showEditCharacterForm(Model model, @PathVariable Long id) {
    model.addAttribute("character", charRep.findOne(id));
    return "edit-character";
  }

  @PostMapping("/edit-character/{id}")
  public String editCharacter(@ModelAttribute Character character, RedirectAttributes redirectAttributes) {
    charRep.save(character);
    redirectAttributes.addAttribute("id",character.getId());
    return "redirect:/view-character/{id}";
  }

}

