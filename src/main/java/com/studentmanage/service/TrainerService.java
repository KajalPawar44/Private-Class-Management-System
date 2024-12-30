package com.studentmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanage.model.Trainer;
import com.studentmanage.repository.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository trainerRepository;
	
	public List<Trainer> getAllTrainer()
	{
		return trainerRepository.findAll();
	}
	public Trainer getTrainerById(Long id)
	{
		return trainerRepository.findById(id).orElseThrow();
	}
	
	public Trainer saveTrainer(Trainer trainer)
	{
		return trainerRepository.save(trainer);
	}
	public void deleteTrainerById(Long id)
	{
		trainerRepository.deleteById(id);
	}
}
