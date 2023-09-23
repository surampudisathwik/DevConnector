package com.dnb.DevConnector.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
public class Experience {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="experience_seq")
//creates instance of generator and calls generator
@GenericGenerator(name = "experience_seq" , strategy= "com.dnb.DevConnector.utils.CustomExperienceIdGenerator", 
	parameters = {@Parameter(name=CustomExperienceIdGenerator.INCREMENT_PARAM,value="50"),
			@Parameter(name= CustomExperienceIdGenerator.VALUE_PREFIX_PARAMETER, value="EXP_"), 
			@Parameter(name=CustomExperienceIdGenerator.NUMBER_FORMAT_PARAMETER, value="%05d")} )
@Column private String exp_id;
private String name;
private String duration;
private String position;
private String description;
@ManyToOne

@JoinColumn(name = "profile_id")

private Profile profile;
}
