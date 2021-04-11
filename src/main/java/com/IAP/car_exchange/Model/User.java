package com.IAP.car_exchange.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Getter
    @Setter
    @Id
    @Size(max = 32)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "middle_name")
    private String middleName;

    @Getter
    @Setter
    @Column(name = "surname")
    private String sureName;

    @Getter
    @Setter
    @Column(name = "pesel")
    private int pesel;

    @Getter
    @Setter
    @Column(name = "gender")
    private char gender;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Getter
    @Setter
    @Column(name = "role")
    private String role;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id", referencedColumnName = "id")
    private Office officeId;

    public User(String firstName, String middleName, String sureName, int pesel, char gender, Date birthDate, String role, Office officeId){
        this.firstName = firstName;
        this.middleName = middleName;
        this.sureName = sureName;
        this.pesel = pesel;
        this.gender = gender;
        this.birthDate = birthDate;
        this.role = role;
        this.officeId = officeId;

    }
}
