/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

  @GetMapping("/create_game")
  public String createGame() {
    return "create_game";
  }

  @GetMapping("/view_game")
  public String viewGame() {
    return "view_game";
  }

  @GetMapping("/edit_game")
  public String editGame() {
    return "create_game";
  }

}
