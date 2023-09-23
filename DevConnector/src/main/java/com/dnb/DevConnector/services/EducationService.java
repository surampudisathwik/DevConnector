package com.dnb.DevConnector.services;

import java.util.Optional;

import com.dnb.DevConnector.dto.Education;
import com.dnb.DevConnector.dto.Profile;

public interface EducationService {
	public Education createEducation(Education education);
	public Optional<Education> getEducationById(String edu_id);
    public boolean deleteEducationById(String edu_id);
    public Iterable<Education> getAllEducation();
}
