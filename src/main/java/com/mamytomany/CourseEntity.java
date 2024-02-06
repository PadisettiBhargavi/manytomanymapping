package com.mamytomany;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class CourseEntity {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String name;

@ManyToMany(mappedBy="courses")
private Set<StudentEntity> students;
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
@Override
public String toString() {
	return "CourseEntity [id=" + id + ", name=" + name + "]";
}
public CourseEntity(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public CourseEntity() {
	super();
}

}
