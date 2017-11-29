/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchGamesController {
  private final GameRepository gameRep;

  public SearchGamesController(GameRepository gameRep) {
    this.gameRep = gameRep;
  }

  @GetMapping("/search-games")
  public String showSearchResults(Model model) {
    model.addAttribute("gameList", gameRep.findAll());

    return "search-games";
  }

  @GetMapping("/games-mapped")
  public String mappedGame() {
    return "games-mapped";
  }

  @Autowired
  private RpgProperties rpgProperties;

  public String mapApi(Model model) {
    model.addAttribute("maps", rpgProperties.maps);
    return "edit";
  }

}