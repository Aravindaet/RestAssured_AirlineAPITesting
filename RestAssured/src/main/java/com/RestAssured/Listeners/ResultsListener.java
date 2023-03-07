package com.RestAssured.Listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tesults.tesults.Results;

public class ResultsListener implements ITestListener {

	List<Map<String, Object>> testCases = new ArrayList<Map<String, Object>>();

	public static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("TestStart method " + getTestMethodName(result) + " start");

	}

	public void onTestSuccess(ITestResult iTestResult) {
		Map<String, Object> testCase = new HashMap<String, Object>();
		testCase.put("name", getTestMethodName(iTestResult));
		testCase.put("suite", "TesultsExample");
		testCase.put("result", "pass");
		testCases.add(testCase);
	}

	public void onTestFailure(ITestResult iTestResult) {
		Map<String, Object> testCase = new HashMap<String, Object>();
		testCase.put("name", getTestMethodName(iTestResult));
		testCase.put("suite", "TesultsExample");
		testCase.put("result", "fail");
		testCases.add(testCase);
	}

	public void onTestSkipped(ITestResult iTestResult) {
		Map<String, Object> testCase = new HashMap<String, Object>();
		testCase.put("name", getTestMethodName(iTestResult));
		testCase.put("suite", "TesultsExample");
		testCase.put("result", "fail");
		testCases.add(testCase);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
		// Map<String, Object> to
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("target",
				"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjlkYWEzMTVlLTFhOGUtNDNmZi1iZjdlLTZmOTg4MjVlOTY1ZC0xNTc2ODEwMjM0ODA5IiwiZXhwIjo0MTAyNDQ0ODAwMDAwLCJ2ZXIiOiIwIiwic2VzIjoiYjgxNTNjM2MtMGY1My00ODBlLWJlNjYtYWFiNGJjMzI4YTU3IiwidHlwZSI6InQifQ.12vpcsCC9IX5QIz6cPDNiKcjOQ3n2UV_X5hmiLZBJmU");

		Map<String, Object> results = new HashMap<String, Object>();
		results.put("cases", testCases);
		data.put("results", results);

		// Uploading
		Map<String, Object> response = Results.upload(data);
		System.out.println("success: " + response.get("success"));
		System.out.println("message: " + response.get("message"));
		System.out.println("warnings: " + ((List<String>) response.get("warnings")).size());
		System.out.println("errors: " + ((List<String>) response.get("errors")).size());
	}

}
