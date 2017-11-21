package com.rpgrealm.rpgrealm.models;

import javax.persistence.*;

@Entity
@Table(name="app_files")
public class AppFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(nullable = false)
    private String file_url;

    @Column
    private String file_name;

//    foreign keys
    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name="character_id")
    private Character character;

}
