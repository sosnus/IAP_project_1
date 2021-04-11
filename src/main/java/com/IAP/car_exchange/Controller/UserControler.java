package com.IAP.car_exchange.Controller;

import com.IAP.car_exchange.Controller.DataHolders.UserData;
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
public class UserControler {
    @Autowired
    Querries DataAccess;

    @GetMapping("user/{user_id}")
    public User getUser(@PathVariable Long user_id){
        return DataAccess.getUserById(user_id);
    }

    @GetMapping("users")
    public @ResponseBody Iterable<User> getUsers(){
        return DataAccess.getAllUsers();
    }

    @PostMapping("/adduser")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ResponseEntity<String> addUser(@RequestBody UserData dataHolder){
        Date date;
        try {
             date = new SimpleDateFormat("yyyy-mm-dd").parse(dataHolder.getBirthDate());
        } catch (ParseException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Date formating error use 'yyyy-mm-dd'", HttpStatus.BAD_REQUEST);
        }
        User user = DataAccess.addUser(
                dataHolder.getFirstName(),
                dataHolder.getMiddleName(),
                dataHolder.getSurname(),
                dataHolder.getPesel(),
                dataHolder.getGender(),
                date,
                dataHolder.getRole(),
                dataHolder.getOfficeId());
        return ResponseEntity.ok(user.toString());
    }
    @PostMapping("edituser/{user_id}")
    public ResponseEntity<String> editUser(@PathVariable("user_id") Long id, @RequestBody UserData dataHolder){
        User user = DataAccess.updateUser(id, dataHolder);
        return ResponseEntity.ok(user.toString());
    }
    @DeleteMapping("deleteuser/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable("user_id") Long id){
        DataAccess.deleteUser(id);
        return ResponseEntity.ok("Removed");
    }
}
