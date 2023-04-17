package com.bettermind.project.reposity;

import com.bettermind.project.entity.Therapist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TherapistRepo extends JpaRepository<Therapist,Integer> {

}
