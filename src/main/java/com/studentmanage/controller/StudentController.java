package com.studentmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanage.model.Student;
import com.studentmanage.service.StudentService;
import com.studentmanage.service.TrainerService;

@Controller
public class StudentController {

	
	
	    @Autowired
	    private StudentService studentService;
	    
	    @Autowired
	    private TrainerService trainerService;

	    @GetMapping("/viewStudent2")
	    public String viewStudents(Model model) {
	        model.addAttribute("liststudent", studentService.getAllStudent());
	        return "ViewStudent1";
	    }

	    // Keep other student-related methods
//	@GetMapping("/getAllStudents")
//	public String getAllStudent2(Model model)
//	{
//		model.addAttribute("liststudent",studentService.getAllStudent());
//		return "ListStudent";           // Reading the data from trainer record
//	}
//	
	
	
	@GetMapping("/addStudent")
	public String AddNewStudent(Model model)
	{
		Student student = new Student();
		model.addAttribute("student", student);	// for adding the data or record in the trainer record
		model.addAttribute("alltrainer",trainerService.getAllTrainer());
		return "NewStudent";	
	}
	
	@PostMapping("/saveStudent")
	public String savestudent(@ModelAttribute("student")Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/viewStudent2";
	}
        
	@GetMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable Integer id,Model model)
	{
		Student student = studentService.getStudentById(id);
		 model.addAttribute("student",student);
		 model.addAttribute("alltrainer",trainerService.getAllTrainer());
		 return "UpdateStudent";		
	}
	
	@PostMapping("/stu/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student2") Student student ) 
	{
		student.setId(id);
		studentService.saveStudent(student);
		return "redirect:/viewStudent2";
	}
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudentById(@PathVariable Integer id)
	{
		studentService.deleteStudentById(id);
		return "redirect:/viewStudent2";
	}
	
}
