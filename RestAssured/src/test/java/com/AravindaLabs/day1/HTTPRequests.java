package com.AravindaLabs.day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class HTTPRequests {

	int id;
	int airlineId;

	@Test(priority = 1, enabled = false)
	public void getUserList() {

		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2), "total", equalTo(12))

				.log().all();
	}

	@Test(priority = 2, enabled = false)
	public void createUser() {

		HashMap<String, String> data = new HashMap<String, String>();
		data.put("Job", "Trainer");
		data.put("name", "Aravinda");

		id = given().contentType("application/json").body(data)

				.when().post("https://reqres.in/api/users").jsonPath().getInt("id");

//				.then().statusCode(201).log().all();

	}

	@Test(priority = 3, dependsOnMethods = "createUser", enabled = false)
	public void updateUser() {

		HashMap<String, String> data = new HashMap<String, String>();
		data.put("Job", "Teacher");
		data.put("name", "Aravinda");

		given().contentType("application/json").body(data)

				.when().put("https://reqres.in/api/users/" + id)

				.then().statusCode(200).log().all();

	}

	@Test(description = "To validate the delete user functionality", priority = 3, dependsOnMethods = "updateUser", enabled = false)
	public void deleteUser() {

		given()

				.when().delete("https://reqres.in/api/users/" + id)

				.then().statusCode(204).log().all();

	}

	@Test(description = "To verify airlines post api call", priority = 4, enabled = true)
	public void createAirlines() {

		HashMap<Object, Object> airlineData = new HashMap<Object, Object>();
		Faker faker = new Faker();
		int id = faker.number().numberBetween(15000, 20000);
		System.out.println(id);
		airlineData.put("id", id);
		String name = faker.name().fullName();
		System.out.println(name);
		airlineData.put("name", name + " " + "Airways");
		String country = faker.address().country();
		airlineData.put("country", country);
		airlineData.put("logo",
				"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png");
		airlineData.put("slogan", "From India Airlines");
		airlineData.put("head_quaters", "Bangalore");
		airlineData.put("website", "www.indianairways.com");
		airlineData.put("established", 2023);

		System.out.println(airlineData);

		airlineId = given().contentType("application/json").body(airlineData)

				.when().post("https://api.instantwebtools.net/v1/airlines/").jsonPath().getInt("id");

		System.out.println(airlineId);

//				.when().post("https://api.instantwebtools.net/v1/airlines/")

//				.then().statusCode(200).log().all();
	}

	@Test(priority = 5, description = "To get airline details by using airline id", enabled = true)
	public void getAirlineDataById() {

		given()

				.when().get("https://api.instantwebtools.net/v1/airlines/" + airlineId).then().statusCode(200).log()
				.all();

	}

}
