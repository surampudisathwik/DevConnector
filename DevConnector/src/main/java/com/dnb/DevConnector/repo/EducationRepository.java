package com.dnb.DevConnector.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.DevConnector.dto.Education;
import com.dnb.DevConnector.dto.Profile;
@Repository
public interface EducationRepository extends CrudRepository<Education, String> {

}
