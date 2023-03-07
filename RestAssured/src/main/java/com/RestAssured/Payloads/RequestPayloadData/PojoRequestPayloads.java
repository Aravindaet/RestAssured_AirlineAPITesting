package com.RestAssured.Payloads.RequestPayloadData;

import java.util.HashMap;
import java.util.Map;

import com.RestAssured.model.AirlineAPI.AirlineApiDetails;

public class PojoRequestPayloads {

	static int airlineId;

	/*
	 * public static void main(String[] args) { createAirlineDataPayload();
	 * System.out.println(createAirlineDataPayload().get("id"));
	 * 
	 * }
	 */

	public static Map<String, Object> createAirlineDataPayload() {
		Map<String, Object> airlineData = new HashMap<String, Object>();
		AirlineApiDetails airlineApiDetails = new AirlineApiDetails();
		airlineId = airlineApiDetails.getId();
		airlineData.put("id", airlineApiDetails.getId());
		airlineData.put("name", airlineApiDetails.getName());
		airlineData.put("country", airlineApiDetails.getCountry());
		airlineData.put("logo", airlineApiDetails.getLogo());
		airlineData.put("slogan", airlineApiDetails.getSlogan());
		airlineData.put("head_quarters", airlineApiDetails.getHead_quarters());
		airlineData.put("website", airlineApiDetails.getWebsite());
		airlineData.put("established", airlineApiDetails.getEstablished());
		return airlineData;
	}

	public static Map<String, Object> duplicateAirlineDataPayload() {
		Map<String, Object> airlineData = new HashMap<String, Object>();
		AirlineApiDetails airlineApiDetails = new AirlineApiDetails();
		airlineData.put("id", airlineId);
		airlineData.put("name", airlineApiDetails.getName());
		airlineData.put("country", airlineApiDetails.getCountry());
		airlineData.put("logo", airlineApiDetails.getLogo());
		airlineData.put("slogan", airlineApiDetails.getSlogan());
		airlineData.put("head_quarters", airlineApiDetails.getHead_quarters());
		airlineData.put("website", airlineApiDetails.getWebsite());
		airlineData.put("established", airlineApiDetails.getEstablished());
		return airlineData;
	}

	public static int singleAirlineIdPayload() {
		return airlineId;
	}

}
