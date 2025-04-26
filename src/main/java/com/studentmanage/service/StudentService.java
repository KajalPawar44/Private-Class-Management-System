package com.studentmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanage.model.Student;
import com.studentmanage.repository.StudentRepository;

@Service
public class StudentService {


	    private final StudentRepository studentRepository;

	    @Autowired
	    public StudentService(StudentRepository studentRepository) {
	        this.studentRepository = studentRepository;
	    }

	    // Keep existing methods
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}
	public Student getStudentById(Integer id)
	{
		return studentRepository.findById(id).orElseThrow();
	}

	public Student saveStudent(Student student)
	{
		return studentRepository.save(student);
	}
	public void deleteStudentById(Integer id)
	{
		studentRepository.deleteById(id);
	}
	public void assignTrainerToStudent(Long studentId, Long trainerId) {
		studentRepository.deleteAll();
	}
	
}

