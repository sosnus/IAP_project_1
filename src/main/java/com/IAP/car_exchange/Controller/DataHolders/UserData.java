package com.IAP.car_exchange.Controller.DataHolders;

import lombok.Data;

@Data
public class UserData {
    String firstName;
    String middleName;
    String surname;
    String pesel;
    char gender;
    String birthDate;
    String role;
    Long officeId;
}
