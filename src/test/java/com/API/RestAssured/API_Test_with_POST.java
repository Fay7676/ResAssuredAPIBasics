package com.API.RestAssured;

import java.io.InputStream;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Test_with_POST {
	
	@Test
	void SendingReqwithPOST() {
		
		//callsing base URI 
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		//calling reqqest specificaotin interface object
		RequestSpecification httpRequest = RestAssured.given();
		
		
		JSONObject objectParam = new JSONObject();
		
		objectParam.put("name", "myFirstName");	
		objectParam.put("salary", "myLsstName");	
		objectParam.put("age", "25");	
		//objectParam.put("id", "786");	
			
		
		
		httpRequest.header("Contnet-Type", "application/Json");
		
		httpRequest.body(objectParam.toJSONString());
		
		Response response = httpRequest.request(Method.POST, "/create");	
		
		String responseBody = response.getBody().asString();
		System.out.println("This is the Response Body: " +responseBody);
		boolean contains = responseBody.contains("Successfully! Record has been added");
		System.out.println("this is the partial message of response body: "+contains);
		Assert.assertTrue(contains);
		
		//Another way
		
		boolean responseBody2 = response.getBody().asString().contains("Successfully! Record has been added");
		
		Assert.assertTrue(responseBody2);
		
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
		String successCode = response.jsonPath().get("status");
		Assert.assertEquals(successCode, "success");
		
		//THINGS YOU CAN DO WITH RESPONSE
		//1. If you don't know the content type, you can use this code to get content type
		String contenttype = response.contentType();
		System.out.println("This is the content type: " +contenttype);
		
		//2. Research InputSteam for more info
		InputStream inputStream = response.asInputStream();
		
		System.out.println("This is the body in inputstream format: " +inputStream);
		
		//3. asPrettyString gets the body in more organized format
		String prettyString = response.asPrettyString();
		System.out.println("This is the body in pretty string fromat: "+prettyString);
		
		//4. Hash codes are numbers assigned to an object by java. to get the hash code, use:
		int hashCode = response.hashCode();
		//1137667747
		System.out.println("This is the hashcode: "+hashCode);
		
		//5. Pretty Print will print the body in Pretty Format in the consul w/out using System.out.println()
		response.prettyPrint();
		//System.out.println("This is the body in Retty Print format: "+prettyPrint);
		
		//6. Print prints the success message in consul w/out using System.out.println()
		response.print();
		
		
		
		
		
		
		
		
	}

}
