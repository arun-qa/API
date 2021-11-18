package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteIssue extends BaseRequest {
	
	@Test
	public void deleteissue() {
		
		response = inputRequest.delete(issue_id);
		
		
	
		
	}

}
