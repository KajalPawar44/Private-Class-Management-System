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

    // Show all trainers
    @GetMapping("/viewTrainers")
    public String getAllTrainer(Model model) {
        model.addAttribute("listtrainer", trainerservice.getAllTrainer());
        return "TrainerExample";  // Thymeleaf page to display trainers
    }

    // Show form to add a new trainer
    @GetMapping("/newTrainer")
    public String AddNewTrainer(Model model) {
        Trainer trainer = new Trainer();
        model.addAttribute("trainer", trainer);
        return "New_Trainer_Form";
    }

    // Save trainer form submission
    @PostMapping("/saveTrainer")
    public String savetrainer(@ModelAttribute("trainer") Trainer trainer) {
        trainerservice.saveTrainer(trainer);
        return "redirect:/viewTrainers";
    }

    // Show form to update trainer by id
    @GetMapping("/upadateTrainer/{id}")
    public String updateTrainerById(@PathVariable Long id, Model model) {
        Trainer trainer = trainerservice.getTrainerById(id);
        model.addAttribute("trainer2", trainer);
        return "UpdateTrainer_Form";
    }

    // Update trainer after form submission
    @PostMapping("/{id}")
    public String updatedTrainer(@PathVariable Long id, @ModelAttribute("trainer2") Trainer trainer) {
        trainer.setId(id); // Ensure same ID is used for updating
        trainerservice.saveTrainer(trainer);
        return "redirect:/viewTrainers";
    }

    // Delete trainer by id
    @GetMapping("/deletetrainer/{id}")
    public String deleteTrainerById(@PathVariable Long id) {
        trainerservice.deleteTrainerById(id);
        return "redirect:/viewTrainers";
    }
}
