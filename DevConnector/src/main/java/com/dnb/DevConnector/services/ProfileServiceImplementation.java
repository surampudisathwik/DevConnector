package com.dnb.DevConnector.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.exceptions.InvalidEmailException;
import com.dnb.DevConnector.mapper.RequestToEntityMapper;
import com.dnb.DevConnector.payload.request.ProfileRequest;
import com.dnb.DevConnector.repo.ProfileRepository;
@Service
public class ProfileServiceImplementation implements ProfileService{
	@Autowired
	ProfileRepository profileRepository;

	@Override
	public Profile createProfile(ProfileRequest profileRequest) {
		// TODO Auto-generated method stub
		Profile profile = RequestToEntityMapper.getProfileEntityObject(profileRequest);
		return profileRepository.save(profile);
	}

	@Override
	public Optional<Profile> getProfileById(String Profilename) {
		// TODO Auto-generated method stub
		return profileRepository.findById(Profilename);
	}

	@Override
	public boolean deleteProfileById(String Profilename) {
		if(profileRepository.existsById(Profilename))
		{
			profileRepository.deleteById(Profilename);
			return true;
		}
		else return false;
	}

	@Override
	public Iterable<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}
	
	

	
}
