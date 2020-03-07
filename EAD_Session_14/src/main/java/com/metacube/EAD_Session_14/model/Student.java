package com.metacube.EAD_Session_14.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;





@Entity
@Table(name = "student")
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Sid")
	private int id;	
	
	@Column(name = "First_name")
	@Size(min = 2 , max = 20, message = "{firstName}")
	@Pattern(regexp = "[A-Z a-z]*")
	private String firstName;
	
	
	@Column(name = "Last_name")
	@Size(min = 2, max = 20,message = "{lastName}")
	@Pattern(regexp = "[A-Z a-z]*")
	private String lastName;
	
	
	@Column(name = "Father_name")
	@Size(min = 2, max = 20,message = "{fatherName}")
	@Pattern(regexp = "[A-Z a-z]*")
	private String fatherName;
	
	
	@Column(name = "Email")
	@NotBlank(message = "{blankEmail}")
	private String email;
	
	
	@Column(name = "Student_class")
	@NotNull(message = "{blankclass}")
	@Min(1)
	@Max(12)
	private int classNo;
	
	
	@Column(name = "age")
	@NotNull(message = "{blankAge}")
	@Min(5)
	@Max(20)
	private int age;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "studentPojo [firstName=" + firstName + ", lastName=" + lastName
				+ ", fatherName=" + fatherName + ", classNo=" + classNo
				+ ", age=" + age + "]";
	}

}
