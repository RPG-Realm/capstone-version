package com.rpgrealm.rpgrealm.models;

import javax.persistence.*;

@Entity
@Table(name="files")
public class Files {
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
    private Users user;

}
