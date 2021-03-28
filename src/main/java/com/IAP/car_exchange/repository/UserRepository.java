package com.IAP.car_exchange.repository;

import com.IAP.car_exchange.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
