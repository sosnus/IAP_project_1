package com.IAP.car_exchange.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "worker_id", nullable = false, referencedColumnName = "id")
    private User worker_id;

    @Getter
    @Setter
    @Id
    @Column(name = "plate_number")
    private String plateNumber;

    @Getter
    @Setter
    @Column(name = "license_number")
    private String licenseNumber;

    @Getter
    @Setter
    @Column(name = "model")
    private String model;

}
