package com.rpgrealm.rpgrealm.models;

import javax.persistence.*;

@Entity
@Table(name="files")
public class File {
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

}
