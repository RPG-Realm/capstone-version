/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.User;
import com.rpgrealm.rpgrealm.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchGamesController {
  private final GameRepository gameRep;

  @Value("${mapsApi}")
  private String mapsApi;

  public SearchGamesController(GameRepository gameRep) {
    this.gameRep = gameRep;
  }

  @GetMapping("/search-games")
  public String showSearchResults(Model model) {
    try{
      User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      model.addAttribute("user",user);
      model.addAttribute("gameList", gameRep.findAll());
      return "search-games";
    }catch (Exception e){
      model.addAttribute("gameList", gameRep.findAll());
      return "search-games";
    }



  }

  @GetMapping("/games-mapped")
  public String mappedGames(Model model) {
    model.addAttribute("mapsApi", mapsApi);
    return "games-mapped";
  }

}

