package com.RestAssured.TestUsingPojo;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RestAssured.Payloads.RequestPayloadData.PojoRequestPayloads;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateAirlineDataPojoTest {

	@Test(description = "To verify airlines post api call", priority = 1)
	public void createAirline() {

		Map<String, Object> payload = PojoRequestPayloads.createAirlineDataPayload();
		Response response = given().contentType(ContentType.JSON).body(payload)

				.when().post("https://api.instantwebtools.net/v1/airlines/");

		System.out.println(response.asString());

		System.out.println("Id got from payload is" + payload.get("id"));

		JSONObject Jo = new JSONObject(response.asString());
		String id = Jo.get("id").toString();
		int airlineId = Integer.parseInt(id);
		System.out.println("AirlineId got from response is" + airlineId);
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
		Assert.assertEquals(Jo.get("id"), payload.get("id"));
	}

	@Test(priority = 2, description = "To create new airline using duplicate airline id")
	public void duplicateAirlineCreation() {
		Map<String, Object> payload = PojoRequestPayloads.duplicateAirlineDataPayload();
		Response response = given().contentType(ContentType.JSON).body(payload).when()
				.post("https://api.instantwebtools.net/v1/airlines/");
		JSONObject Jo = new JSONObject(response.asString());
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
		Assert.assertEquals(response.header("Content-Length"), "73");
		Assert.assertEquals(Jo.get("message"), "there is an airline registered under same id you've entered");
	}

	@Test(priority = 3, description = "To get the airline details of a specific airline id")
	public void getAirlineUsingAirlineId() {

		int airlineId = PojoRequestPayloads.singleAirlineIdPayload();

		Response response = given().when().get("https://api.instantwebtools.net/v1/airlines/" + airlineId);

		JSONObject jo = new JSONObject(response.asString());

		String airId = jo.get("id").toString();
		int airLineId = Integer.parseInt(airId);
		Assert.assertEquals(airlineId, airLineId);
	}

	@Test(priority = 4, description = "To get all the airline details", enabled = true)
	public void getAllAirlineDetails() {

		/*
		 * int airlineId = PojoRequestPayloads.singleAirlineIdPayload(); String airId =
		 * String.valueOf(airlineId); System.out.println(airlineId);
		 */

//		Response response = 

		given()

				.when().get("https://api.instantwebtools.net/v1/airlines").then().statusCode(200);

//		JSONArray jsonArray = new JSONArray(response.asString());

		/*
		 * boolean Status = false; for (int i = 0; i < jsonArray.length(); i++) {
		 * JSONObject jo = new JSONObject(i); String Id = jo.getString("id").toString();
		 * // int airLineId=Integer.parseInt(Id); if (airId.equals(Id)) { Status = true;
		 * } else { Status = Status; } System.out.println(Status);
		 * 
		 * }
		 */

	}

}
