package com.mamytomany;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courseEntity")
public class CourseEntityController {
@Autowired
private CourseEntityRepo courseRepo;
@PostMapping
public ResponseEntity<CourseEntity> saveCourseEntity(@RequestBody CourseEntity course){
	CourseEntity savedCourseEntity=courseRepo.save(course);
	return new ResponseEntity<CourseEntity>(savedCourseEntity,HttpStatus.CREATED) ;
	
}
@GetMapping
public ResponseEntity<List<CourseEntity>> getAllCourseEntities(){
	List<CourseEntity> courses=courseRepo.findAll();
	return new ResponseEntity<List<CourseEntity>>(courses,HttpStatus.OK);
}
@GetMapping("/{id}")
public ResponseEntity<CourseEntity> getCourseEntityById(@PathVariable int id){
	Optional<CourseEntity> course=courseRepo.findById(id);
	if(course.isPresent()) {
		return new ResponseEntity<CourseEntity>(course.get(),HttpStatus.OK);
	}
	else {
		return new ResponseEntity<CourseEntity>(HttpStatus.NOT_FOUND);
	}
}
@PutMapping("/{id}")
public ResponseEntity<CourseEntity> updateCourseEntity(@PathVariable int id,@RequestBody CourseEntity updatedCourse){
	Optional<CourseEntity> existingCourse=courseRepo.findById(id);
	if(existingCourse.isPresent()) {
		CourseEntity course=existingCourse.get();
		course.setName(updatedCourse.getName());
		CourseEntity savedCourse=courseRepo.save(course);
		return new ResponseEntity<CourseEntity>(savedCourse,HttpStatus.OK);
	}
	return new ResponseEntity<CourseEntity>(HttpStatus.NOT_FOUND);
	
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteCourseEntity(@PathVariable int id){
	Optional<CourseEntity> course=courseRepo.findById(id);
	if(course.isPresent()) {
		courseRepo.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	else {
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
}
