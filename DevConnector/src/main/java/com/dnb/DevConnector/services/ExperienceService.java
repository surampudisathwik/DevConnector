package com.dnb.DevConnector.services;

import java.util.Optional;

import com.dnb.DevConnector.dto.Education;
import com.dnb.DevConnector.dto.Experience;

public interface ExperienceService {
	public Experience createExperience(Experience experience);
	public Optional<Experience> getExperienceById(String exp_id);
    public boolean deleteExperienceById(String exp_id);
    public Iterable<Experience> getAllExperience();
}
