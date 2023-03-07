package com.FakeAPI.test.AilinePassengers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class PassengerDataTest {

	String passengerId;

	@Test(priority = 1, description = "To create passenger")
	public void createPassenger() {
		HashMap<Object, Object> passengerData = new HashMap<Object, Object>();
		Faker faker = new Faker();

		String name = faker.name().fullName();
		passengerData.put("name", name);
		int tripId = faker.number().numberBetween(1, 100);
		passengerData.put("trips", tripId);
		passengerData.put("airline", 15171);

		passengerId = given().contentType("application/json").body(passengerData)

				.when().post("https://api.instantwebtools.net/v1/passenger").jsonPath().getString("_id");
		//
		// System.out.println(passengerId);

	}

	@Test(priority = 2, dependsOnMethods = "createPassenger", description = "To get the details of the passenger using passenger ID")
	public void getPassengerDetail() {
		given()

				.when().get("https://api.instantwebtools.net/v1/passenger/" + passengerId).then().statusCode(200).log()
				.all();

	}

	@Test(priority = 3, description = "To Update the passenger details")
	public void updatePassengerName() {
		HashMap<String, String> passengerData = new HashMap<String, String>();
		passengerData.put("name", "Aravinda ETI");

		given().contentType("application/json").body(passengerData).

				when().patch("https://api.instantwebtools.net/v1/passenger/" + passengerId)

				.then().statusCode(200).body("message", equalTo("Passenger data updated successfully.")).log().all();

	}

	@Test(priority = 4, description = "To Update all the details of the passenger")
	public void updatePassengerDetails() {
		HashMap<Object, Object> passengerData = new HashMap<Object, Object>();
		Faker faker = new Faker();
		String name = faker.name().fullName();
		passengerData.put("name", name);
		passengerData.put("trips", 125);
		passengerData.put("airline", 15171);

		given().contentType("application/json").body(passengerData).when()
				.put("https://api.instantwebtools.net/v1/passenger/" + passengerId)

				.then().statusCode(200).body("message", equalTo("Passenger data put successfully completed.")).log()
				.all();

	}

	@Test(priority = 5, description = "To Delete the passenger details")
	public void deletePassenger() {

		Response response = given()

				.when().delete("https://api.instantwebtools.net/v1/passenger/" + passengerId);

//				.then().statusCode(200).body("message", equalTo("Passenger data deleted successfully.")).log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
		Assert.assertEquals(response.header("Content-Length"), 50);
//		List<Header> headers = response.headers().asList();
//		System.out.println(headers);
		String message = response.jsonPath().get("message").toString();
		Assert.assertEquals(message, "Passenger data deleted successfully.");

//		JSONObject jsonObject = new JSONObject(response.toString());
	}

}
