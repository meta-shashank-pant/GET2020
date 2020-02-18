package com.metacube.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Student {
	
	@NotBlank(message = "Please enter first name.")
	private String first_name;
	
	@NotBlank(message = "Please enter last name.")
	private String last_name;
	
	@NotBlank(message = "Please enter father name.")
	private String father_name;
	
	@NotBlank(message = "Please enter your email.")
	@Email(message = "{badEmail}")
	private String email;
	
	@Min(value = 1, message = "Class should be greater than 1.")
	@Max(value = 12, message = "Class should be less than 12.")
	private int s_class = 1;
	
	@Min(value = 1, message = "Age should not be less than 1")
    @Max(value = 50, message = "Age should not be greater than 50")
	private int age = 1;
	
	Integer  id;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setS_class(int s_class) {
		this.s_class =  s_class;
	}
	public int getS_class() {
		return s_class;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
