package com.dnb.DevConnector.dto;
import java.util.UUID;
import java.util.regex.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.DevConnector.exceptions.InvalidEmailException;
import com.dnb.DevConnector.exceptions.InvalidPasswordException;
import com.dnb.DevConnector.utils.CustomProfileIdGenerator;
import com.dnb.DevConnector.utils.CustomUserIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="user_seq")
//creates instance of generator and calls generator
@GenericGenerator(name = "user_seq" , strategy= "com.dnb.DevConnector.utils.CustomUserIdGenerator", 
	parameters = {@Parameter(name=CustomUserIdGenerator.INCREMENT_PARAM,value="50"),
			@Parameter(name= CustomUserIdGenerator.VALUE_PREFIX_PARAMETER, value="USER_"), 
			@Parameter(name=CustomUserIdGenerator.NUMBER_FORMAT_PARAMETER, value="%05d")} )
@Column private String user_id;
@Column private String UserMail;
@Column private String Password;
@Column private String UserName;
@Column private UUID UUID1;
@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")

	private Profile profile;

	
}
