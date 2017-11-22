/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.rpgrealm.rpgrealm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GamesMappedController {
  @GetMapping("/games_mapped")
  public String showGamesMapped() {
    return "games_mapped";
  }
}