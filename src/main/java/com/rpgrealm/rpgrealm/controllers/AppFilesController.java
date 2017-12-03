package com.rpgrealm.rpgrealm.controllers;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.rpgrealm.rpgrealm.models.AppFile;
import com.rpgrealm.rpgrealm.models.Character;
import com.rpgrealm.rpgrealm.models.User;
import com.rpgrealm.rpgrealm.repositories.AppFileRepository;
import com.rpgrealm.rpgrealm.repositories.CharacterRepository;
import com.rpgrealm.rpgrealm.repositories.GameRepository;
import com.rpgrealm.rpgrealm.repositories.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppFilesController {

  private final AppFileRepository fileRep;
  private final GameRepository gameRep;
  private final Users usrRep;
  private final CharacterRepository charRep;

  public AppFilesController(AppFileRepository fileRep, GameRepository gameRep, Users usrRep, CharacterRepository charRep) {
    this.fileRep = fileRep;
    this.gameRep = gameRep;
    this.usrRep = usrRep;
    this.charRep = charRep;
  }

  @GetMapping("upload-file")
  public String showFileForm(Model model) {
    model.addAttribute("appfile", new AppFile());
    return "/home";
  }

  @PostMapping("/upload-file")
  public String createFile(@JacksonInject String response, @JacksonInject Long gameId, @JacksonInject String filename, @JacksonInject String mimetype) {

    System.out.println(response);
    System.out.println(gameId);
    System.out.println(filename);

    AppFile appfile = new AppFile();
    appfile.setGame(gameRep.findOne(gameId));
    appfile.setFile_url(response);
    appfile.setFile_name(filename);
    appfile.setMime_type(mimetype);
    fileRep.save(appfile);
    return "/home";
  }

  @PostMapping("/upload-file/user-profile")
  public String userProfilePicture(@JacksonInject String response, @JacksonInject String filename, @JacksonInject String mimetype){
    AppFile appFile = new AppFile();
    User principalUser=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User user=usrRep.findOne(principalUser.getId());
    appFile.setFile_url(response);
    appFile.setFile_name(filename);
    appFile.setMime_type(mimetype);
    appFile.setUser(user);
    user.setProfile_photo(appFile);

    fileRep.save(appFile);
    usrRep.save(user);

    return "/home";
  }

  @PostMapping("/upload-file/character-files")
  public String characterFiles(@JacksonInject String response, @JacksonInject String filename, @JacksonInject String mimetype, @JacksonInject Long characterId){

      AppFile appFile =new AppFile();
      User principalUser=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      User user=usrRep.findOne(principalUser.getId());
      Character character=charRep.findOne(characterId);
      appFile.setFile_url(response);
    appFile.setFile_name(filename);
    appFile.setMime_type(mimetype);
    appFile.setCharacter(character);
    appFile.setUser(user);
    fileRep.save(appFile);
    if(mimetype.equalsIgnoreCase("application/pdf")){
        character.setPdf(appFile);

    }else if(mimetype.equalsIgnoreCase("image/jpeg")|| mimetype.equalsIgnoreCase("image/png")){
        character.setImage(appFile);

    }
    charRep.save(character);
    return "/home";
  }
}
