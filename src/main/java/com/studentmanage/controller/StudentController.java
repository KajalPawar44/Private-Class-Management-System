package com.studentmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanage.model.Student;
import com.studentmanage.model.Trainer;
import com.studentmanage.service.StudentService;
import com.studentmanage.service.TrainerService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentservice;
	@Autowired
	private TrainerService trainerservice;
	@GetMapping("/viewStudent1")
	public String getAllStudent1(Model model)
	{
		model.addAttribute("liststudent",studentservice.getAllStudent());
		return "ViewStudent1";           // Reading the data from trainer record
	}
	@GetMapping("/viewStudent2")
	public String getAllStudent2(Model model)
	{
		model.addAttribute("liststudent",studentservice.getAllStudent());
		return "ListStudent";           // Reading the data from trainer record
	}
	
	
	
	@GetMapping("/addStudent")
	public String AddNewStudent(Model model)
	{
		Student student = new Student();
		model.addAttribute("student", student);	// for adding the data or record in the trainer record
		model.addAttribute("alltrainer",trainerservice.getAllTrainer());
		return "NewStudent";	
	}
	
	@PostMapping("/saveStudent")
	public String savestudent(@ModelAttribute("student")Student student)
	{
		studentservice.saveStudent(student);
		return "redirect:/viewStudent";
	}
        
	@GetMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable int id,Model model)
	{
		Student student = studentservice.getStudentById(id);
		 model.addAttribute("student2",student);
		 model.addAttribute("alltrainer",trainerservice.getAllTrainer());
		 return "UpdateStudent";		
	}
	
	@PostMapping("/stu/{id}")
	public String updateStudent(@PathVariable Integer id,@ModelAttribute("student2") Student student ) 
	{
		student.setId(id);
        studentservice.saveStudent(student);
		return "redirect:/viewStudent";
	}
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudentById(@PathVariable Integer id)
	{
		studentservice.deleteStudentById(id);
		return "redirect:/viewStudent";
	}
	
}
