package com.rpgrealm.rpgrealm.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private String description;

  @Column
  private String type;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User game_master;

  @Column
  private String voice_server;

  @OneToOne
  private AppFile image_id;

  @Column
  private String play_time;

  @Column
  private String created_time;

  @Column
  private String location_name;

  @Column
  private String address;

  @Column
  private String city;

  @Column
  private String state;

  @Column
  private Long zip_code;

  @Column
  private Long rating;

  @Column
  private Long isactive;

  // mapped properties

  @OneToMany(mappedBy = "game")
  private List<AppFile> game_files;

  public Game() {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public User getGame_master() {
    return game_master;
  }

  public void setGame_master(User game_master) {
    this.game_master = game_master;
  }

  public String getVoice_server() {
    return voice_server;
  }

  public void setVoice_server(String voice_server) {
    this.voice_server = voice_server;
  }

  public AppFile getImage_id() {
    return image_id;
  }

  public void setImage_id(AppFile image_id) {
    this.image_id = image_id;
  }

  public String getPlay_time() {
    return play_time;
  }

  public void setPlay_time(String play_time) {
    this.play_time = play_time;
  }

  public String getCreated_time() {
    return created_time;
  }

  public void setCreated_time(String created_time) {
    this.created_time = created_time;
  }

  public String getLocation_name() {
    return location_name;
  }

  public void setLocation_name(String location_name) {
    this.location_name = location_name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Long getZip_code() {
    return zip_code;
  }

  public void setZip_code(Long zip_code) {
    this.zip_code = zip_code;
  }

  public Long getRating() {
    return rating;
  }

  public void setRating(Long rating) {
    this.rating = rating;
  }

  public Long getIsactive() {
    return isactive;
  }

  public void setIsactive(Long isactive) {
    this.isactive = isactive;
  }

  public List<AppFile> getGame_files() {
    return game_files;
  }

  public void setGame_files(List<AppFile> game_files) {
    this.game_files = game_files;
  }
}