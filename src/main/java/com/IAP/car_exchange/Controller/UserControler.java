package com.IAP.car_exchange.Controller;

import com.IAP.car_exchange.Model.User;
import com.IAP.car_exchange.repository.Querries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


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
}
