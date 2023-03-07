package com.RestAssured.RequestPayloads;

import java.util.HashMap;
import java.util.Map;

import com.RestAssured.Datamodel.ReadData;
import com.github.javafaker.Faker;

public class RequestPayloads {

	static ReadData readData;

	static Faker faker = new Faker();

//	static Faker faker;
	public static int id;

	public static Map<String, Object> getAirlineData() {
		Map<String, Object> airlineData = new HashMap<String, Object>();
//		Faker faker = new Faker();
		id = faker.number().numberBetween(15000, 20000);
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
		return airlineData;
	}

	public static Map<String, Object> getPassengerDataFromMap() {
		Map<String, Object> passengerData = new HashMap<String, Object>();
		Faker faker = new Faker();
		passengerData.put("name", faker.name().fullName());
		passengerData.put("trips", faker.number().numberBetween(20, 50));
		passengerData.put("airline", id);
		return passengerData;

	}

	public static Map<String, Object> sampleDataUsingPojo() {
		Map<String, Object> sampleData = new HashMap<String, Object>();
		readData.setName(faker.name().fullName());
		readData.setCountry(faker.address().country());

		return sampleData;
	}

}
