package com.IAP.car_exchange.Controller;

import com.IAP.car_exchange.Controller.DataHolders.CarData;
import com.IAP.car_exchange.Controller.DataHolders.UserData;
import com.IAP.car_exchange.Model.Car;
import com.IAP.car_exchange.Model.User;
import com.IAP.car_exchange.repository.Querries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class CarControler {
    @Autowired
    Querries DataAccess;

    @GetMapping("car/{plate_number}")
    public Car getCar(@PathVariable String plateNumber){
        return DataAccess.getCarByPlate(plateNumber);
    }

    @GetMapping("cars")
    public @ResponseBody
    Iterable<Car> getCars(){
        return DataAccess.getAllCars();
    }

    @PostMapping("/addcar")
    public @ResponseBody
    ResponseEntity<String> addCAr(@RequestBody CarData dataHolder){
        Car car = DataAccess.addCar(dataHolder.getPlateNumber(),
                dataHolder.getLicenseNumber(),
                dataHolder.getModel(),
                dataHolder.getWorker_id());
        return ResponseEntity.ok(car.toString());
    }
    @PostMapping("editcar")
    public ResponseEntity<String> editUser(@RequestBody CarData dataHolder){
        Car car = DataAccess.updateCar(dataHolder.getPlateNumber(), dataHolder);
        return ResponseEntity.ok(car.toString());
    }
    @DeleteMapping("deletecar/{plate}")
    public ResponseEntity<String> deleteUser(@PathVariable("plate") String plate){
        DataAccess.deleteCar(plate);
        return ResponseEntity.ok("Removed");
    }
}
