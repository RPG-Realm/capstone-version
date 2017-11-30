package com.rpgrealm.rpgrealm.controllers;


import com.rpgrealm.rpgrealm.models.AppFile;
import com.rpgrealm.rpgrealm.models.Game;
import com.rpgrealm.rpgrealm.repositories.AppFileRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class AppFilesController {

  private final AppFileRepository fileRep;

  public AppFilesController(AppFileRepository fileRep) {
    this.fileRep = fileRep;
  }

  @GetMapping("/files/get-file")
  public String showFileForm(Model model) {
    model.addAttribute("appfile", new AppFile());
    return "home";
  }

  @PostMapping("/files/add-file")
  public String createFile(@ModelAttribute AppFile appFile) {
    fileRep.save(appFile);
    return "home";
  }
}
