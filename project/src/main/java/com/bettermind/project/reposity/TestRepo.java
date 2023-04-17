package com.bettermind.project.reposity;

import com.bettermind.project.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test,Integer> {
}
