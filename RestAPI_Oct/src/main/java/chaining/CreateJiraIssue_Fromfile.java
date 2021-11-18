package chaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJiraIssue_Fromfile extends BaseRequest {
	
	@Test
	public void createjiraissue() {
		File inputPayLoadFile = new File("./data/jiradata.json");
		inputRequest.contentType("application/json")
					.accept("application/json")
					.body(inputPayLoadFile);
					response = inputRequest.post();
					issue_id = response.jsonPath().get("id");
					System.out.println("issue id is "+issue_id);
	}

}
