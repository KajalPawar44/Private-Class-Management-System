package com.studentmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanage.model.Trainer;
import com.studentmanage.service.TrainerService;

@Controller
public class TrainerController {
@Autowired
private TrainerService trainerservice;
@GetMapping("/viewTrainers")
public String getAllTrainer(Model model)
{
	model.addAttribute("listtrainer",trainerservice.getAllTrainer());
	return "TrainerExample";           // Reading the data from trainer record
}


@GetMapping("/newTrainer")
public String AddNewTrainer(Model model)
{
	Trainer trainer = new Trainer();
	model.addAttribute("trainer", trainer);	// for adding the data or record in the trainer record
	return "New_Trainer_Form";	
}
@PostMapping("/saveTrainer")
public String savetrainer(@ModelAttribute("trainer")Trainer trainer)
{
	trainerservice.saveTrainer(trainer);
	return "redirect:/viewTrainers";
}
@GetMapping("/upadateTrainer/{id}")
public String updateTrainerById(@PathVariable Long id, Model model)
{
	Trainer trainer= trainerservice.getTrainerById(id);
	model.addAttribute("trainer2", trainer);
	return "UpdateTrainer_Form";
//	return "redirect:/viewTrainers";
	
	
}
@PostMapping("/{id}")
public String updatedTrainer(@PathVariable Long id,@ModelAttribute("trainer2")Trainer trainer) {
	
	trainer.setId(id);          // postMapping is liye ki naya record create na kar sake or usi id ko update kar sake ..
	trainerservice.saveTrainer(trainer);
	return "redirect:/viewTrainers";
}
@GetMapping("/deletetrainer/{id}")
public String deleteTrainerById(@PathVariable Long id)
{
	trainerservice.deleteTrainerById(id);
	return "redirect:/viewTrainers";        // for deleting the existing trainer from record
	
}
}
