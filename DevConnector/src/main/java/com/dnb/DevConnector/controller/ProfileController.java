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

import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.exceptions.IdNotFoundException;
import com.dnb.DevConnector.payload.request.ProfileRequest;
import com.dnb.DevConnector.services.ProfileService;
@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	@Autowired
	ProfileService profileService;
	
	@PostMapping("/create")
	public Profile createProfile(@RequestBody ProfileRequest profileRequest) {
		return profileService.createProfile(profileRequest);
	}
	

@GetMapping("/getid/{profile_id}")
public ResponseEntity<?> getProfileById
(@PathVariable("profile_id") String profile_id) throws IdNotFoundException {
	Optional<Profile> optional = profileService.getProfileById(profile_id);
	if(optional.isPresent()) {
		return ResponseEntity.ok(optional.get());
	}
	else {
		throw new IdNotFoundException("Id not valid");
	}
}

@DeleteMapping("/{profile_id}")
public ResponseEntity<?> deleteProfileById
(@PathVariable("profile_id") String profile_id) throws IdNotFoundException{
	if(profileService.getProfileById(profile_id)!=null) {
		profileService.deleteProfileById(profile_id);
		return ResponseEntity.ok("Deleted");
	}
	else {
		throw new IdNotFoundException("ID is not valid");
	}
}

@GetMapping("/getall")
public ResponseEntity<?> getAllProfile() {
	Iterable<Profile> listofProfile = profileService.getAllProfiles();
	return ResponseEntity.ok(listofProfile);

}
}
