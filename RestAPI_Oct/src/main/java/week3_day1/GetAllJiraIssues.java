package week3_day1;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllJiraIssues {

	@Test
	public void getallissues()
	{
		RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/search";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","1tFDjllY3jwISCost2cZ8C09");
		RequestSpecification inputRequest = RestAssured
				.given()
				.log()
				.all()
				.queryParam("JQL", "Project=RA")
				.accept("application/json");
				Response get_response = inputRequest.get();
				int statuscode = get_response.statusCode();
				System.out.println("statuscode: "+ statuscode);
				get_response.prettyPrint();
				List<String>issue_id_list = get_response.jsonPath().get("issues.id");
				System.out.println("size is: "+issue_id_list.size());
		
	}
}
