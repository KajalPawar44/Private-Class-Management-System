package com.studentmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanage.model.Student;
import com.studentmanage.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentrepository;
	
	public List<Student> getAllStudent()
	{
		return studentrepository.findAll();
	}
	public Student getStudentById(Integer id)
	{
		return studentrepository.findById(id).orElseThrow();
	}

	public Student saveStudent(Student student)
	{
		return studentrepository.save(student);
	}
	public void deleteStudentById(Integer id)
	{
		studentrepository.deleteById(id);
	}
}
