/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.rpgrealm.rpgrealm.models.AppFile;
import com.rpgrealm.rpgrealm.models.Game;
import com.rpgrealm.rpgrealm.repositories.AppFileRepository;
import com.rpgrealm.rpgrealm.repositories.CharacterRepository;
import com.rpgrealm.rpgrealm.models.User;
import com.rpgrealm.rpgrealm.repositories.GameRepository;
import com.rpgrealm.rpgrealm.repositories.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {
  private final GameRepository gameRep;
  private final CharacterRepository charRep;
  private final AppFileRepository appRep;
  private final Users usrRep;

  public GameController(GameRepository gameRep, CharacterRepository charRep, AppFileRepository appRep, Users usrRep)
  {
    this.gameRep=gameRep;
    this.charRep=charRep;
    this.appRep=appRep;
    this.usrRep=usrRep;
  }

  @GetMapping("/create-game")
  public String createGame(Model model) {
    model.addAttribute("game", new Game());
    return "create-game";
  }

  @PostMapping("/create-game")
  public String saveGameToDb(Game game){
    User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    game.setGame_master(user);
    gameRep.save(game);
    return "redirect:home";
  }

  @GetMapping("/view-game/{id}")
  public String viewGame(@PathVariable Long id, Model model) {

    model.addAttribute("game",gameRep.findOne(id));
    return "view-game";
  }

  @GetMapping("/view-game/all")
  public String viewblankGame( Model model) {

    User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    model.addAttribute("gameList",gameRep.findByUserId(user.getId()));
    return "my-games";
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

  @GetMapping("/join-game/{id}")
  public String joinGameForm(@PathVariable Long id, Model model){
    model.addAttribute("game", gameRep.findOne(id));
    model.addAttribute("characterList", charRep.findByUserId(4L));
    return "select-character";
  }

//  drop the get request in the url, just use the post from ajax. Use @RequestAttribute to get the names from ajax
  
  @PostMapping("/join-game")
  public String commitJoinGame(@RequestParam Long gameId, @RequestParam Long characterId){
    User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    AppFile appfile=new AppFile();
    appfile.setFile_url("placeholder");
    appfile.setCharacter(charRep.findOne(characterId));
    appfile.setUser(usrRep.findOne(user.getId()));
    appfile.setGame(gameRep.findOne(gameId));
    appRep.save(appfile);

    return "redirect:home";
  }

}
