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
  private AppFile image;

  @OneToOne
  private AppFile pdf;

  // mapped properties

  @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
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

  public AppFile getImage() {
    return image;
  }

  public void setImage(AppFile image) {
    this.image = image;
  }

  public AppFile getPdf() {
    return pdf;
  }

  public void setPdf(AppFile pdf) {
    this.pdf = pdf;
  }

  public List<AppFile> getCharacter() {
    return character_files;
  }

  public void setCharacter(List<AppFile> character) {
    this.character_files = character_files;
  }
}
