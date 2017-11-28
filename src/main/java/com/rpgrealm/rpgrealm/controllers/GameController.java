/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;


import com.rpgrealm.rpgrealm.models.Game;
import com.rpgrealm.rpgrealm.repositories.GameRepository;
import com.rpgrealm.rpgrealm.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {
  private final GameRepository gameRep;

  public GameController(GameRepository gameRep){
    this.gameRep=gameRep;
  }

  @GetMapping("/create-game")
  public String createGame(Model model) {
    model.addAttribute("game", new Game());
    return "create-game";
  }

  @PostMapping("/create-game")
  public String saveGameToDb(Game game){
    gameRep.save(game);
    return "redirect:view-game";
  }

  @GetMapping("/view-game/{id}")
  public String viewGame(@PathVariable Long id, Model model) {

    model.addAttribute("game",gameRep.findOne(id));
    return "view-game";
  }

  @GetMapping("/view-game/")
  public String viewblankGame(@PathVariable Long id, Model model) {

    model.addAttribute("game",gameRep.findOne(id));
    return "view-game";
  }

  @GetMapping("/edit-game/{id}")
  public String editGame(@PathVariable Long id, Model model) {
    model.addAttribute("game", gameRep.findOne(id));
    return "edit-game";
  }
  @PostMapping("edit-game/{id}")
  public String commitEditGame(@PathVariable Long id, @ModelAttribute Game game){

    gameRep.save(game);
    return "home";
  }


}
