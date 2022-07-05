package com.retokrugermc.retokruger.models;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personId")
    private Integer personId;

    @Column (name = "identification")
    private String identification;

    @Column (name = "firstName")
    private String firstName;

    @Column (name = "lastName")
    private String lastName;

    @Column (name = "email")
    private String email;

    @Column (name = "rol")
    private String rol;

    @Column(name = "nameUser")
    private String nameUser;

    @Column(name = "passwordUser")
    private String passwordUser;

}
