package com.mamytomany;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class StudentEntity {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;
private String dob;
private String gender;

@ManyToMany
@JoinTable(name="student_course",joinColumns=@JoinColumn(name="student_id"),inverseJoinColumns=@JoinColumn(name="course_id"))
private Set<CourseEntity> courses;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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

public Set<CourseEntity> getCourses() {
	return courses;
}

public void setCourses(Set<CourseEntity> courses) {
	this.courses = courses;
}

@Override
public String toString() {
	return "StudentEntity [id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", courses=" + courses
			+ "]";
}

public StudentEntity(int id, String name, String dob, String gender, Set<CourseEntity> courses) {
	super();
	this.id = id;
	this.name = name;
	this.dob = dob;
	this.gender = gender;
	this.courses = courses;
}

public StudentEntity() {
	super();
}

}

