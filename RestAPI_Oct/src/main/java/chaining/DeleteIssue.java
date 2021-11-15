package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteIssue extends BaseRequest {
	
	@Test
	public void deleteissue() {
		
		Response delete_response = inputRequest.delete("22137");
		int statuscode = delete_response.statusCode();
		System.out.println("statuscode: "+ statuscode);
	
		
	}

}
