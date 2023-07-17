package com.onlineKart.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineKart.models.User;

public interface UserRepo extends JpaRepository<User, String>{

}
