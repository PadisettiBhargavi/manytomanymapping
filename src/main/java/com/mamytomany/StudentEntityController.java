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
@RequestMapping("/api/studentEntity")
public class StudentEntityController {
	@Autowired
	private StudentEntityRepo studentRepo;
	@PostMapping
	public ResponseEntity<StudentEntity> saveStudentEntity(@RequestBody StudentEntity student){
		StudentEntity savedStudentEntity=studentRepo.save(student);
		return new ResponseEntity<StudentEntity>(savedStudentEntity,HttpStatus.CREATED) ;
		
	}
	@GetMapping
	public ResponseEntity<List<StudentEntity>> getAllStudentEntities(){
		List<StudentEntity> Student=studentRepo.findAll();
		return new ResponseEntity<List<StudentEntity>>(Student,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<StudentEntity> getStudentEntityById(@PathVariable int id){
		Optional<StudentEntity> Student=studentRepo.findById(id);
		if(Student.isPresent()) {
			return new ResponseEntity<StudentEntity>(Student.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<StudentEntity>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<StudentEntity> updateStudentEntity(@PathVariable int id,@RequestBody StudentEntity updatedStudent){
		Optional<StudentEntity> existingStudent=studentRepo.findById(id);
		if(existingStudent.isPresent()) {
			StudentEntity Student=existingStudent.get();
			Student.setName(updatedStudent.getName());
			Student.setDob(updatedStudent.getDob());
			Student.setGender(updatedStudent.getGender());
			StudentEntity savedStudent=studentRepo.save(Student);
			return new ResponseEntity<StudentEntity>(savedStudent,HttpStatus.OK);
		}
		return new ResponseEntity<StudentEntity>(HttpStatus.NOT_FOUND);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudentEntity(@PathVariable int id){
		Optional<StudentEntity> Student=studentRepo.findById(id);
		if(Student.isPresent()) {
			studentRepo.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	}


