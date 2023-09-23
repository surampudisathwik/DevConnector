package com.dnb.DevConnector.dto;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.DevConnector.utils.CustomProfileIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
public class Profile {
@Id
//@NotBlank(message = "account id should not be blank")
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="profile_seq")
//creates instance of generator and calls generator
@GenericGenerator(name = "profile_seq" , strategy= "com.dnb.DevConnector.utils.CustomProfileIdGenerator", 
	parameters = {@Parameter(name=CustomProfileIdGenerator.INCREMENT_PARAM,value="50"),
			@Parameter(name= CustomProfileIdGenerator.VALUE_PREFIX_PARAMETER, value="PRO_"), 
			@Parameter(name=CustomProfileIdGenerator.NUMBER_FORMAT_PARAMETER, value="%05d")} )
@Column private String profile_id;
@Column private String status;
@Column private String company;
@Column private String Website;
@Column private String Location;
@Column private String skills;
@Column private String Username;
@Column private String bio;
@Column private String URL;
@OneToOne

@JoinColumn(name = "user_id")

private User user;



@OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")

private List<Education> educations;



@OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")

private List<Experience> experiences;

}

