package com.dnb.DevConnector.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.DevConnector.utils.CustomEducationIdGenerator;
import com.dnb.DevConnector.utils.CustomExperienceIdGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class Education {

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="education_seq")
//creates instance of generator and calls generator
@GenericGenerator(name = "education_seq" , strategy= "com.dnb.DevConnector.utils.CustomEducationIdGenerator", 
	parameters = {@Parameter(name=CustomEducationIdGenerator.INCREMENT_PARAM,value="50"),
			@Parameter(name= CustomEducationIdGenerator.VALUE_PREFIX_PARAMETER, value="EDU_"), 
			@Parameter(name=CustomEducationIdGenerator.NUMBER_FORMAT_PARAMETER, value="%05d")} )
@Column String edu_id;
private String name;
private String duration;
private String degree;
private String FOS;
private String description;

@ManyToOne

@JoinColumn(name = "profile_id")

private Profile profile;
}
