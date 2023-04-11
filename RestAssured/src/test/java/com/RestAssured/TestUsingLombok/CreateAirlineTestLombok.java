package com.RestAssured.TestUsingLombok;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RestAssured.Payload.RequestPayloadUsingLombok;
import com.RestAssured.Payloads.RequestPayloadData.PojoRequestPayloads;
import com.RestAssured.Pojos.Airline;
import com.RestAssured.Pojos.PassengersData;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateAirlineTestLombok {

	
	@Test(description = "To verify airlines post api call", priority = 1)
	public void createAirline() {

//		Map<String, Object> payload = PojoRequestPayloads.createAirlineDataPayload();
		
		Airline payload=RequestPayloadUsingLombok.getCreateAirlinePayloadFromPojo();
		
		System.out.println("Request payload is"+payload);
		
		Response response = given().contentType(ContentType.JSON).body(payload)

				.when().post("https://api.instantwebtools.net/v1/airlines/");
		
		System.out.println("Response is"+response.asString());
		
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test
	public void createAirlineAndVerifyResponse() throws Exception {
		Airline payload=RequestPayloadUsingLombok.getCreateAirlinePayloadFromPojo();
		
		Response response = given().contentType(ContentType.JSON).body(payload)
				.when().post("https://api.instantwebtools.net/v1/airlines/");

		/*Assert.assertEquals(response.statusCode(), 200);
		JSONObject jo=new JSONObject(response.asString());
		int id=jo.getInt("id");
		Assert.assertEquals(id, payload.getId());*/
		
		ObjectMapper objectMapper=new ObjectMapper();
		Airline createAirlineResponse=objectMapper.readValue(response.getBody().asString(), Airline.class);
		
		System.out.println("Response is" + createAirlineResponse);
		System.out.println("Request is"+ payload);
		
		Assert.assertEquals(createAirlineResponse, payload);
	}
	
	@Test
	public void createPassengerTest() {
		PassengersData passengerDatapayload=RequestPayloadUsingLombok.passengerRequestPayload();
		
//		Response response=
				given()
		         .contentType(ContentType.JSON).body(passengerDatapayload)
		.when()
		          .post("https://api.instantwebtools.net/v1/passenger").then().log().all();
		
	}
	
	
	
	
}
