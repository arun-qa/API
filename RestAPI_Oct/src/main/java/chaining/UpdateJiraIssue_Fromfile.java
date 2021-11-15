package chaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateJiraIssue_Fromfile extends BaseRequest {
	
	@Test
	public void updatejiraissue() {
		File inputPayLoadFile = new File("./data/jiradata.json");
		RequestSpecification inputRequest = RestAssured
				.given()
				.contentType("application/json")
				.accept("application/json")
				.body(inputPayLoadFile);
				Response create_response = inputRequest.put();
				create_response.prettyPrint();
				
	}

}
