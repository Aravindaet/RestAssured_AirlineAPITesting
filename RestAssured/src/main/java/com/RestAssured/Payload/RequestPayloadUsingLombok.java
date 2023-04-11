package com.RestAssured.Payload;

import com.RestAssured.Pojos.Airline;
import com.RestAssured.Pojos.PassengersData;
import com.github.javafaker.Faker;

public class RequestPayloadUsingLombok {
	
	public static void main(String[] args) {
//		System.out.println(getCreateAirlinePayloadFromPojo());
		System.out.println(passengerRequestPayload());
	}
	
	

	static Faker faker = new Faker();

	public static Airline getCreateAirlinePayloadFromPojo() {
		return Airline.
				builder()
				.id(faker.number().numberBetween(75000, 76000))
				.name(faker.name().fullName() +" "+"Airways")
				.country("India")
				.logo("https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/Singapore_Airlines_Logo_2.svg")
				.slogan("A Great Way to Fly")
				.head_quaters("Bangalore, India")
				.website("www.singaporeair.com")
				.established(String.valueOf(faker.number().numberBetween(1990, 2000)))
				.build();
	}
	
	public static PassengersData passengerRequestPayload() {
		return PassengersData.builder().name(faker.name().fullName()).trips(faker.number().digits(2)).
				airline(80872).build();
		
	}
	
	
	
	

}
