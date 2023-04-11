package com.RestAssured.Pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder=true)
@JsonIgnoreProperties(ignoreUnknown=true)

public class PassengersData {

	private String name;
	private String trips;
	private int airline;
	
	
	

}