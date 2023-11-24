package com.example.prabhas.userserver.dao;

import com.example.prabhas.userserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository< UserEntity,String> {

}
