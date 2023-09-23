package com.dnb.DevConnector.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.DevConnector.dto.Education;
import com.dnb.DevConnector.repo.EducationRepository;
import com.dnb.DevConnector.repo.ProfileRepository;
@Service
public class EducationServiceImplementation implements EducationService{

	@Autowired
	EducationRepository educationRepository;
	
	@Override
	public Education createEducation(Education education) {
		
		return educationRepository.save(education);
	}

	@Override
	public Optional<Education> getEducationById(String edu_id) {
		// TODO Auto-generated method stub
		return educationRepository.findById(edu_id);
	}

	@Override
	public boolean deleteEducationById(String edu_id) {
		if(educationRepository.existsById(edu_id))
		{
			educationRepository.deleteById(edu_id);
			return true;
		}
		else return false;
	}

	@Override
	public Iterable<Education> getAllEducation() {
		return educationRepository.findAll();
	}

}
