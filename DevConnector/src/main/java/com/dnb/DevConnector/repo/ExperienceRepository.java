package com.dnb.DevConnector.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.DevConnector.dto.Experience;
@Repository
public interface ExperienceRepository extends CrudRepository<Experience, String> {

}
