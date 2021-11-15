package week3_day1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateJiraIssue_Fromfile {
	
	@Test
	public void updatejiraissue() {
		File inputPayLoadFile = new File("./data/jiradata.json");
		RestAssured.baseURI=("https://api-may2020.atlassian.net/rest/api/2/issue/RA-11290");
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","1tFDjllY3jwISCost2cZ8C09");
		RequestSpecification inputRequest = RestAssured
				.given()
				.contentType("application/json")
				.accept("application/json")
				.body(inputPayLoadFile);
				Response create_response = inputRequest.put();
				create_response.prettyPrint();
				
	}

}
