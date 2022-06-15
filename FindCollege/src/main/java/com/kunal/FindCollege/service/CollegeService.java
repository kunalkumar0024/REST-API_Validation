package com.kunal.FindCollege.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.kunal.FindCollege.entity.College;
import com.kunal.FindCollege.repo.CollegeRepository;
@Service
public class CollegeService {
	@Autowired
	private CollegeRepository collegeRepo;
	
	//@GetMapping("colleges")
	public List<College> getAllCollege(){
		List<College> collegeList=new ArrayList<>();
		collegeRepo.findAll()
		.forEach(collegeList::add);
        return collegeList;
	}
	
	public College addCollege(College college) {
		return collegeRepo.save(college);
	}
	
//	public ResponseEntity<College> addCollege(College college){
//		College newCollege=collegeRepo.save(college);
//		return new ResponseEntity<>(newCollege,HttpStatus.CREATED);
//	}
//	
	public void updateCollege(String collegeId,College college) {
		collegeRepo.save(college);
	}
	
	public void deleteCollege(String collegeId) {
		collegeRepo.deleteById(collegeId);
	}
}
