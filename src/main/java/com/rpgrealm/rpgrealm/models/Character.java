package com.rpgrealm.rpgrealm.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "characters")
public class Character {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private String description;

  @Column
  private String type;

  @OneToOne
  private AppFile image_id;

  @OneToOne
  private AppFile file_id;

  // mapped properties

  @OneToMany(mappedBy = "character")
  private List<AppFile> character_files;

  public Character() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<AppFile> getCharacter_files() {
    return character_files;
  }

  public void setCharacter_files(List<AppFile> character_files) {
    this.character_files = character_files;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AppFile getImage_id() {
    return image_id;
  }

  public void setImage_id(AppFile image_id) {
    this.image_id = image_id;
  }

  public AppFile getFile_id() {
    return file_id;
  }

  public void setFile_id(AppFile file_id) {
    this.file_id = file_id;
  }

  public List<AppFile> getCharacter() {
    return character_files;
  }

  public void setCharacter(List<AppFile> character) {
    this.character_files = character_files;
  }
}
