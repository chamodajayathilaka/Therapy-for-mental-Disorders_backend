package com.bettermind.project.reposity;

import com.bettermind.project.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepo extends JpaRepository<Treatment,Integer> {
}
