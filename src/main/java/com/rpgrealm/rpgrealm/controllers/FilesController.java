package com.rpgrealm.rpgrealm.controllers;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.rpgrealm.rpgrealm.models.AppFile;
import com.rpgrealm.rpgrealm.repositories.AppFileRepository;
import com.rpgrealm.rpgrealm.repositories.CharacterRepository;
import com.rpgrealm.rpgrealm.repositories.GameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FilesController {

  private final AppFileRepository fileRep;
  private final GameRepository gameRep;

  public FilesController(AppFileRepository fileRep, GameRepository gameRep) {
    this.fileRep = fileRep;
    this.gameRep = gameRep;
  }

  @GetMapping("upload-file")
  public String showFileForm(Model model) {
    model.addAttribute("appfile", new AppFile());
    return "/home";
  }

  @PostMapping("upload-file")
  public String createFile(@JacksonInject String response, @JacksonInject Long gameId, @JacksonInject String filename) {

    System.out.println(response);
    System.out.println(gameId);
    System.out.println(filename);

    AppFile appfile = new AppFile();
    appfile.setGame(gameRep.findOne(gameId));
    appfile.setFile_url(response);
    appfile.setFile_name(filename);

    fileRep.save(appfile);
    return "/home";
  }
}
