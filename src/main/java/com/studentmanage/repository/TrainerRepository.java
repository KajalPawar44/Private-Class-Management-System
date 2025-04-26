package com.studentmanage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.studentmanage.model.Trainer;
import com.studentmanage.model.User;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Long> {
	  Optional<Trainer> findByName(String trainerName);
}
