package chaining;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {
	
	public static RequestSpecification inputRequest;
	public static String issue_id;
	public static Response response;
	
	
	@BeforeMethod
	public void setAuthandEndpoint()
	{
	RestAssured.baseURI=("https://api-may2020.atlassian.net/rest/api/2/issue");
	RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","1tFDjllY3jwISCost2cZ8C09");
	inputRequest = RestAssured.given().log().all();
	
	}
	
	@AfterMethod
	public void displayresponse()
	{
		System.out.println("status code is "+response.statusCode());
		response.prettyPrint();
	}
	

}
