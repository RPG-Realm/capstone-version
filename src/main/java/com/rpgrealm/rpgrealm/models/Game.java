package com.rpgrealm.rpgrealm.models;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String game_name;

  @Column
  private String game_description;

  @Column
  private String game_type;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User game_master;

  @Column
  private String game_voice_server;

  @OneToOne
  private File game_image_id;

  @Column
  private String game_play_time;

  @Column
  private String game_created_time;

  @Column
  private String game_location_name;

  @Column
  private String game_address;

  @Column
  private String game_city;

  @Column
  private String game_state;

  @Column
  private Long game_created_zip_code;

  @Column
  private Long game_rating;

  @Column
  private Long game_isactive;

  public Game() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGame_name() {
    return game_name;
  }

  public void setGame_name(String game_name) {
    this.game_name = game_name;
  }

  public String getGame_description() {
    return game_description;
  }

  public void setGame_description(String game_description) {
    this.game_description = game_description;
  }

  public String getGame_type() {
    return game_type;
  }

  public void setGame_type(String game_type) {
    this.game_type = game_type;
  }

  public User getGame_master() {
    return game_master;
  }

  public void setGame_master(User game_master) {
    this.game_master = game_master;
  }

  public String getGame_voice_server() {
    return game_voice_server;
  }

  public void setGame_voice_server(String game_voice_server) {
    this.game_voice_server = game_voice_server;
  }

  public File getGame_image_id() {
    return game_image_id;
  }

  public void setGame_image_id(File game_image_id) {
    this.game_image_id = game_image_id;
  }

  public String getGame_play_time() {
    return game_play_time;
  }

  public void setGame_play_time(String game_play_time) {
    this.game_play_time = game_play_time;
  }

  public String getGame_created_time() {
    return game_created_time;
  }

  public void setGame_created_time(String game_created_time) {
    this.game_created_time = game_created_time;
  }

  public String getGame_location_name() {
    return game_location_name;
  }

  public void setGame_location_name(String game_location_name) {
    this.game_location_name = game_location_name;
  }

  public String getGame_address() {
    return game_address;
  }

  public void setGame_address(String game_address) {
    this.game_address = game_address;
  }

  public String getGame_city() {
    return game_city;
  }

  public void setGame_city(String game_city) {
    this.game_city = game_city;
  }

  public String getGame_state() {
    return game_state;
  }

  public void setGame_state(String game_state) {
    this.game_state = game_state;
  }

  public Long getGame_created_zip_code() {
    return game_created_zip_code;
  }

  public void setGame_created_zip_code(Long game_created_zip_code) {
    this.game_created_zip_code = game_created_zip_code;
  }

  public Long getGame_rating() {
    return game_rating;
  }

  public void setGame_rating(Long game_rating) {
    this.game_rating = game_rating;
  }

  public Long getGame_isactive() {
    return game_isactive;
  }

  public void setGame_isactive(Long game_isactive) {
    this.game_isactive = game_isactive;
  }
}