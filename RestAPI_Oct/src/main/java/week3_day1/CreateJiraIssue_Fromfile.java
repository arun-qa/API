package week3_day1;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJiraIssue_Fromfile {
	
	@Test
	public void createjiraissue() {
		File inputPayLoadFile = new File("./data/jiradata.json");
		RestAssured.baseURI=("https://api-may2020.atlassian.net/rest/api/2/issue");
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","1tFDjllY3jwISCost2cZ8C09");
		RequestSpecification inputRequest = RestAssured
				.given()
				.contentType("application/json")
				.accept("application/json")
				.body(inputPayLoadFile);
				Response create_response = inputRequest.post();
				create_response.prettyPrint();
				String issue_id = create_response.jsonPath().get("id");
				System.out.println("id is "+issue_id);
	}

}
