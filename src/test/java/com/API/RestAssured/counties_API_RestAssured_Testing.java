package com.API.RestAssured;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.Assert.*;

public class counties_API_RestAssured_Testing {

	@Test
	void countiesAPITest() {

		RestAssured.baseURI="https://restcountries.eu/rest/v2/name";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/Afghanistan");

		String jsonResponse = response.getBody().asString();

		System.out.println(jsonResponse);

		String prettyString = response.asPrettyString();

		System.out.println("This is the jason response in pretty string format: " +prettyString);

		//verifying status code

		int statusCode = response.getStatusCode();
		System.out.println("This is status code: " +statusCode);
		Assert.assertEquals(statusCode, 200);

		//Verifying Statud line

		String statusLine = response.getStatusLine();
		System.out.println("This is status line: "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 ");

		//validating content type
		String contentType = response.getHeader("Content-Type");
		System.out.println("This is the content type: "+contentType);

		String server = response.getHeader("server");
		System.out.println("This is the server: "+server);

		String date = response.getHeader("Date");
		System.out.println("This is the date: "+date);
		
		String contentEncoding = response.getHeader("Content-Encoding");
		System.out.println("This is the content-encoding: "+contentEncoding);
	}

}
