package com.IAP.car_exchange.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "offices")
public class Office {
    @Getter
    @Setter
    @Id
    @Size(max = 32)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    @Column(name = "city")
    private String city;

    @Getter
    @Setter
    @Column(name = "type")
    private String type;
}
