package com.kunal.FindCollege.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.kunal.FindCollege.entity.College;
import com.kunal.FindCollege.service.CollegeService;

@RestController
@RequestMapping("/colleges")
public class CollegeController{

	@Autowired
	public CollegeService collegeService;
	
	@GetMapping("/get-college-list")
	public List<College> getAllCollege(){
		return collegeService.getAllCollege();
	}
	
//	@PostMapping("/add-college")
//	public void addCollege(@Validated @RequestBody College college) {
//	    collegeService.addCollege(college);
//	}
//	
	@PostMapping("/add-college")
	public ResponseEntity<College> addCollege(@Valid  @RequestBody College college){
		College createCollege=this.collegeService.addCollege(college);
		return new ResponseEntity<>(createCollege,HttpStatus.CREATED);
	}
	@PutMapping("/update-college/{collegeId}")
	public void updateCollege(@PathVariable String collegeId,@RequestBody College college) {
		collegeService.updateCollege(collegeId,college);
	}
	
	@DeleteMapping("/delete-college/{collegeId}")
	public void deleteCollege(@PathVariable String collegeId) {
		collegeService.deleteCollege(collegeId);
	}
	
	
	
	
}
