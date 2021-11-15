package week3_day2;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCRWithHeader {
	
	@Test
	public void createcrwithheader() {
		File inputPayLoadFile = new File("./data/testdata.json");
		RestAssured.baseURI = "https://dev97130.service-now.com/api/now/table/change_request";
		//RestAssured.authentication = RestAssured.basic("admin", "vwSdP6qaSJ8T");
		RequestSpecification inputRequest = RestAssured
				.given()
				.header("authorization", "Basic YWRtaW46dndTZFA2cWFTSjhU")
				.contentType("application/json")
				.queryParams("sysparm_fields","sys_id,short_description")
				.accept(ContentType.JSON)
				.body(inputPayLoadFile);				
				Response create_response = inputRequest.post();
				create_response.prettyPrint();
				String sys_id = create_response.jsonPath().get("result.sys_id");
				System.out.println("sys_id is : "+sys_id);

	}

}
