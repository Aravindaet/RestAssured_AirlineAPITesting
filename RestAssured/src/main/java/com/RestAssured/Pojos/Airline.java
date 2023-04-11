package com.RestAssured.Pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder=true)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Airline {

	private int id;
	private String name;
	private String country;
	private String logo;
	private String slogan;
	private String head_quaters;
	private String website;
	private String established;

}
