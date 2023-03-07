package com.AravindaLabs.test.day2;

import java.util.HashMap;

import org.testng.annotations.Test;

public class PostDataCreation {

	@Test
	public void testPostUsingHashMap() {

		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "TestUser1");
		data.put("job", "Data Analyst");

	}

}
