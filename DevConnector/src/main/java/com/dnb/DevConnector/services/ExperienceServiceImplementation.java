package com.dnb.DevConnector.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.DevConnector.dto.Experience;
import com.dnb.DevConnector.repo.ExperienceRepository;
@Service
public class ExperienceServiceImplementation implements ExperienceService {
	@Autowired
	ExperienceRepository experienceRepository;
	
	@Override
	public Experience createExperience(Experience experience) {
		// TODO Auto-generated method stub
		return experienceRepository.save(experience);
	}

	@Override
	public Optional<Experience> getExperienceById(String exp_id) {
		// TODO Auto-generated method stub
		return experienceRepository.findById(exp_id);
	}

	@Override
	public boolean deleteExperienceById(String exp_id) {
		if(experienceRepository.existsById(exp_id))
		{
			experienceRepository.deleteById(exp_id);
			return true;
		}
		else return false;
	}

	@Override
	public Iterable<Experience> getAllExperience() {
		
		return experienceRepository.findAll();
	}

}
