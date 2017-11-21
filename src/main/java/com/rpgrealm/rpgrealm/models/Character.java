package com.rpgrealm.rpgrealm.models;

import javax.persistence.*;

@Entity
@Table(name = "characters")
public class Character {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String character_name;

  @Column
  private String character_type;

  @Column
  private Long character_image_id;

  @Column
  private Long character_file_id;

  public Character() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCharacter_name() {
    return character_name;
  }

  public void setCharacter_name(String character_name) {
    this.character_name = character_name;
  }

  public String getCharacter_type() {
    return character_type;
  }

  public void setCharacter_type(String character_type) {
    this.character_type = character_type;
  }

  public Long getCharacter_image_id() {
    return character_image_id;
  }

  public void setCharacter_image_id(Long character_image_id) {
    this.character_image_id = character_image_id;
  }

  public Long getCharacter_file_id() {
    return character_file_id;
  }

  public void setCharacter_file_id(Long character_file_id) {
    this.character_file_id = character_file_id;
  }
}
