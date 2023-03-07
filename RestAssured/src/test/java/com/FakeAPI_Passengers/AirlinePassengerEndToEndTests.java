package com.FakeAPI_Passengers;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RestAssured.Datamodel.ReadData;
import com.RestAssured.RequestPayloads.RequestPayloads;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AirlinePassengerEndToEndTests {

	ReadData readData;

	int airlineId;
	String passengerId;

	@Test(priority = 1, description = "To verify airlines post api call", enabled = true)
	public void createAirline() {
		/*
		 * HashMap<Object, Object> airlineData = new HashMap<Object, Object>(); Faker
		 * faker = new Faker(); int id = faker.number().numberBetween(15000, 20000);
		 * airlineData.put("id", id); String name = faker.name().fullName();
		 * airlineData.put("name", name + " " + "Airways"); String country =
		 * faker.address().country(); airlineData.put("country", country);
		 * airlineData.put("logo",
		 * "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png"
		 * ); airlineData.put("slogan", "From Indian Airlines");
		 * airlineData.put("head_quaters", "Bangalore"); airlineData.put("website",
		 * "www.indianairways.com"); airlineData.put("established", 2023);
		 * System.out.println(airlineData);
		 */

		Map<String, Object> payload = RequestPayloads.getAirlineData();

		airlineId = given().contentType(ContentType.JSON).body(payload)

				.when().post("https://api.instantwebtools.net/v1/airlines/").jsonPath().getInt("id");

		// .when().post("https://api.instantwebtools.net/v1/airlines/")

		// .then().statusCode(200).log().all();
	}

	@Test(priority = 2, description = "To create a new passenger details")
	public void createPassenger() {
		// createAirline();

		/*
		 * HashMap<Object, Object> passengerData = new HashMap<Object, Object>();
		 * 
		 * Faker faker = new Faker(); String passengerName = faker.name().fullName();
		 * int trips = faker.number().numberBetween(5, 25); passengerData.put("name",
		 * passengerName); passengerData.put("trips", trips);
		 * passengerData.put("airline", airlineId);
		 * 
		 * 
		 * System.out.println(passengerData);
		 */

		Map<String, Object> payload = RequestPayloads.getPassengerDataFromMap();
		System.out.println(payload);

		Response response = given().contentType(ContentType.JSON).body(payload)

				.when().post("https://api.instantwebtools.net/v1/passenger");

		// System.out.println(response.asString());

		JSONArray jsonArray = new JSONArray(response.toString());
		JSONObject jsonObject = new JSONObject(response.asString());
		passengerId = jsonObject.getJSONArray("airline").getJSONObject(0).get("_id").toString(); //
		String passengerid = jsonObject.getJSONObject("_id").toString();
		String airlineid = jsonObject.getJSONArray("airline").getJSONObject(0).get("id").toString();
		int airId = Integer.parseInt(airlineid); //
		System.out.println("Airline Id got from JSON Object method is" + ":" + airlineid);
		Assert.assertEquals(airId, airlineId);

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 3, enabled = false, description = "To get the details of the passenger using passenger ID")
	public void getPassengerDetail() {
		given()

				.when().get("https://api.instantwebtools.net/v1/passenger/" + passengerId).then().statusCode(200).log()
				.all();

	}

}
