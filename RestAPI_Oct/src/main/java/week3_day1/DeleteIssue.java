package week3_day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteIssue {
	
	@Test
	public void deleteissue() {
		
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","1tFDjllY3jwISCost2cZ8C09");
		RequestSpecification inputRequest = RestAssured
		.given()
		.log()
		.all();
		Response delete_response = inputRequest.delete("22137");
		int statuscode = delete_response.statusCode();
		System.out.println("statuscode: "+ statuscode);
	
		
	}

}
