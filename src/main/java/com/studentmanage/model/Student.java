package com.studentmanage.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="Full Name")
	private String full_name;
	@Column(name="DOB")
	private String dob;
	@Column(name="Gender")
	private String gender;
	@Column(name="Email")
	private String email;
	@Column(name="Phone No")
	private String phone_no;
	@Column(name="Address")
	private String address;
	@Column(name="Course")
	private String course;
	@Column(name="Department")
	private String department;
	
	@ManyToOne
	@JoinColumn(name="trainer_id")
	private Trainer trainer;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student( String full_name, String dob, String gender, String email, String phone_no, String address,
			String course, String department, Trainer trainer) {
		
		this.full_name = full_name;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone_no = phone_no;
		this.address = address;
		this.course = course;
		this.department = department;
		this.trainer = trainer;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id2) {
		this.id = id2;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	

	
	
}
