package com.dnb.DevConnector.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.DevConnector.dto.Education;
import com.dnb.DevConnector.dto.Experience;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.services.EducationService;
import com.dnb.DevConnector.services.ExperienceService;
@RestController
@RequestMapping("/api/education")
public class EducationController {
	@Autowired
	EducationService educationService;
	@PostMapping("/create")
	public Education createEducation(@RequestBody Education education) {
		return educationService.createEducation(education);
	}
	
	
	@GetMapping("/getid/{edu_id}")
	public ResponseEntity<?> getEducationById
	(@PathVariable("edu_id") String edu_id) throws IdNotFoundException {
		Optional<Education> optional = educationService.getEducationById(edu_id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new IdNotFoundException("Id not valid");
		}
	}

	@DeleteMapping("/{exp_id}")
	public ResponseEntity<?> deleteEducationById
	(@PathVariable("edu_id") String edu_id) throws IdNotFoundException{
		if(educationService.getEducationById(edu_id)!=null) {
			educationService.deleteEducationById(edu_id);
			return ResponseEntity.ok("Deleted");
		}
		else {
			throw new IdNotFoundException("ID is not valid");
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllEducation() {
		Iterable<Education> listofEducation = educationService.getAllEducation();
		return ResponseEntity.ok(listofEducation);

	}
}
