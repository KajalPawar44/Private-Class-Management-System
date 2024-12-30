package com.studentmanage.model;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Trainer_table")
public class Trainer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="Name")
	private String name;
	@Column(name="Profile")
	private String profile;
	@Column(name="Experience")
	private double experience;
	
	@OneToMany(mappedBy="trainer")
	 List<Student> student;

	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer( String name, String profile, double experience, List<Student> student) {
		
		this.name = name;
		this.profile = profile;
		this.experience = experience;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
		
	}
	
	
	
}
