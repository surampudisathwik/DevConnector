package com.dnb.DevConnector.payload.request;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import lombok.Data;
@Data
public class ProfileRequest {
	 private String status;
	 private String company;
	 private String Website;
	 private String Location;
	private List<String> skills;
	 private String Username;
	 private String bio;
	 private String URL;
}
