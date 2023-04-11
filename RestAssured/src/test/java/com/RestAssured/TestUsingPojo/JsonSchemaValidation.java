package com.RestAssured.TestUsingPojo;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import com.RestAssured.Payloads.RequestPayloadData.PojoRequestPayloads;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {

	@Test
	public void createAirlineJsonSchemaValidation() {
		Map<String, Object> payload = PojoRequestPayloads.createAirlineDataPayload();

		given().contentType(ContentType.JSON).body(payload)

				.when().post("https://api.instantwebtools.net/v1/airlines/")

				.then().assertThat()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("createAirlineJsonSchema.json"));

	}

	@Test
	public void getAirlineDetailsJsonSchemaValidation() {

		given()

				.when().get("https://api.instantwebtools.net/v1/airlines")

				.then().assertThat()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("AllAirlineDetailsJsonSchema.json"));

	}

	@Test
	public void test() {

	}

}
