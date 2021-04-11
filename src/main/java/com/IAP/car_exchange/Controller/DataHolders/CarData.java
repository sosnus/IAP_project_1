package com.IAP.car_exchange.Controller.DataHolders;

import lombok.Data;

@Data
public class CarData {
    String plateNumber;
    String licenseNumber;
    String model;
    Long worker_id;
}
