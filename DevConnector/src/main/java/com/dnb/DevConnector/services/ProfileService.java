package com.dnb.DevConnector.services;

import java.util.Optional;

import com.dnb.DevConnector.dto.Profile;
import com.dnb.DevConnector.dto.User;
import com.dnb.DevConnector.exceptions.InvalidEmailException;
import com.dnb.DevConnector.payload.request.ProfileRequest;

public interface ProfileService {
	public Profile createProfile(ProfileRequest profileRequest);
	public Optional<Profile> getProfileById(String Profilename);
    public boolean deleteProfileById(String Profilename)  ;
    public Iterable<Profile> getAllProfiles();
}
