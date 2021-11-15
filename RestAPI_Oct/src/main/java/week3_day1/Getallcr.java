package week3_day1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getallcr {
	
	@Test
	public void getallcr() {
		RestAssured.baseURI = "https://dev97130.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "vwSdP6qaSJ8T");
		Map<String,String> inputQueryParams = new HashMap<String,String>();
		inputQueryParams.put("sysparm_fields","sys_id,priority");
		inputQueryParams.put("priority", "1");
		RequestSpecification inputRequest = RestAssured
											.given()
											.queryParams(inputQueryParams)
											.accept("application/json");
		Response response = inputRequest.get();
		int statusCode = response.statusCode();
		System.out.println("statuscode is"+ statusCode);
		response.prettyPrint();
		List<String> sys_id_list = response.jsonPath().getList("result.sys_id");
		System.out.println("Number of records: "+sys_id_list.size());
		
		
		
	}
	

}
;