package com.RestAssured.Datamodel;

import java.util.HashMap;
import java.util.Map;

import com.github.javafaker.Faker;

public class ReadData {

	private String name;
	private String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static Map<String, Object> getAirlineData() {
		Map<String, Object> airlineData = new HashMap<String, Object>();
		Faker faker = new Faker();
		int id = faker.number().numberBetween(15000, 20000);
		airlineData.put("id", id);
		String name = faker.name().fullName();
		airlineData.put("name", name + " " + "Airways");
		String country = faker.address().country();
		airlineData.put("country", country);
		airlineData.put("logo",
				"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png");
		airlineData.put("slogan", "From Indian Airlines");
		String headquarter = faker.address().cityName();
		airlineData.put("head_quaters", headquarter);
		airlineData.put("website", "www.indianairways.com");
		airlineData.put("established", 2023);
//		System.out.println(airlineData);
		return airlineData;
	}

}