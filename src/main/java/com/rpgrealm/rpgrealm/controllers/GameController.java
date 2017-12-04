/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.rpgrealm.rpgrealm.models.AppFile;
import com.rpgrealm.rpgrealm.models.Character;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;

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
  public String saveGameToDb(@ModelAttribute Game game, RedirectAttributes redirectAttributes){
    User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    game.setGame_master(user);
    gameRep.save(game);
    redirectAttributes.addAttribute("id",game.getId());
    return "redirect:/view-game/{id}";
  }

  @GetMapping("/view-game/{id}")
  public String viewGame(@PathVariable Long id, Model model) {
//    Return the active game
    Game activeGame=gameRep.findOne(id);
//    Get a list of the characters tagged to this game
    List<Character> characterList=activeGame.getCharacters();
//    Make a hash map of the characters and their owners username
    HashMap<Character, String> gamePair =new HashMap<>();
    for(Character character: characterList){
      gamePair.put(character, character.getUser().getUsername());
    }
//    make a hash map for the characters and their picture urls
    HashMap<Character, String> gameCharPics=new HashMap<>();
    for(Character character:characterList){
      if(character.getImage()!=null){
        gameCharPics.put(character, character.getImage().getFile_url());
      }
    }
//    Check who user is to compare versus game owner
    User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User dbUser=usrRep.findOne(user.getId());
//    Get a character list of the session user in the game
    List<Character> userList=charRep.findByUserAndGame(dbUser.getId(),activeGame.getId());
//    Get all the files tied to the game
    List<AppFile> gameFiles=activeGame.getGame_files();
    System.out.println(gameFiles.toString());

    model.addAttribute("game",activeGame);
    model.addAttribute("characterList",characterList);
    model.addAttribute("hashUser", gamePair);
    model.addAttribute("hashPic", gameCharPics);
//    gets game owner
    model.addAttribute("owner",activeGame.getGame_master());
    model.addAttribute("user",dbUser);
//    Pass in list of a users characters to validate join.
    if(!userList.isEmpty()){
      model.addAttribute("myList",userList);
    }
//    Pass game filesList
    if(!gameFiles.isEmpty()){
      model.addAttribute("gameFiles",gameFiles);
    }
    return "view-game";
  }

  @GetMapping("/view-game/all")
  public String viewblankGame( Model model) {

    User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User dbUser=usrRep.findOne(user.getId());
    model.addAttribute("gameList",gameRep.findByUserId(user.getId()));
    model.addAttribute("user",dbUser);
    return "my-games";
  }

  @GetMapping("/edit-game/{id}")
  public String editGame(@PathVariable Long id, Model model) {
    model.addAttribute("game", gameRep.findOne(id));
    return "edit-game";
  }
  @PostMapping("edit-game/{id}")
  public String commitEditGame(@ModelAttribute Game game, RedirectAttributes redirectAttributes){

    gameRep.save(game);
    redirectAttributes.addAttribute("id",game.getId());
    return "redirect:/view-game/{id}";
  }

  @GetMapping("/join-game/{id}")
  public String joinGameForm(@PathVariable Long id, Model model){
    User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    model.addAttribute("game", gameRep.findOne(id));
    model.addAttribute("characterList", charRep.findByUserId(user.getId()));
    return "select-character";
  }

//  drop the get request in the url, just use the post from ajax. Use @RequestAttribute to get the names from ajax
  
  @PostMapping("/join-game")
  public String commitJoinGame(@JacksonInject Long gameId, @JacksonInject Long characterId, RedirectAttributes redirectAttributes){
    User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Game gameJoined = gameRep.findOne(gameId);
    List<Character> gamesCharacters = gameJoined.getCharacters();
    gamesCharacters.add(charRep.findOne(characterId));
    gameJoined.setCharacters(gamesCharacters);
    gameRep.save(gameJoined);
    redirectAttributes.addAttribute("id",gameId);
    return "redirect:/view-game/{id}";
  }

}
