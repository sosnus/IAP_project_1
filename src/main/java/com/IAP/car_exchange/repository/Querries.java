package com.IAP.car_exchange.repository;

import com.IAP.car_exchange.Model.User;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Data
public class Querries {
    final UserRepository userRepository;

    public Querries(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserById(long id) throws IllegalArgumentException {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new IllegalArgumentException("There are no users with id=" + id + "!"));
    }

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}
