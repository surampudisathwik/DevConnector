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

import com.dnb.DevConnector.dto.Experience;
import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.services.ExperienceService;
@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
	@Autowired
	ExperienceService experienceService;
	
	
	@PostMapping("/create")
	public Experience createExperience(@RequestBody Experience experience) {
		return experienceService.createExperience(experience);
	}
	
	
	@GetMapping("/getid/{exp_id}")
	public ResponseEntity<?> getExperienceById
	(@PathVariable("exp_id") String exp_id) throws IdNotFoundException {
		Optional<Experience> optional = experienceService.getExperienceById(exp_id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new IdNotFoundException("Id not valid");
		}
	}

	@DeleteMapping("/{exp_id}")
	public ResponseEntity<?> deleteExperienceById
	(@PathVariable("exp_id") String exp_id) throws IdNotFoundException{
		if(experienceService.getExperienceById(exp_id)!=null) {
			experienceService.deleteExperienceById(exp_id);
			return ResponseEntity.ok("Deleted");
		}
		else {
			throw new IdNotFoundException("ID is not valid");
		}
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllExperience() {
		Iterable<Experience> listofExperience = experienceService.getAllExperience();
		return ResponseEntity.ok(listofExperience);

	}
}
