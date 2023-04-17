package com.bettermind.project.reposity;

import com.bettermind.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
