package stepdefn;

import org.hamcrest.Matchers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCRImplementation {
	
	public static RequestSpecification inputobject;
	public static Response outputresponse;
	
	@Given("Set the endpoint for CR in service now application")
	public void setEndPoint() {
		RestAssured.baseURI = "https://dev97130.service-now.com/api/now/table/change_request";
	}
	@And("Set the Authentication for Service now API")
	public void setAuthentication() {
		RestAssured.authentication = RestAssured.basic("admin", "vwSdP6qaSJ8T");
	}
	@And("Set the content-type in Create CR API")
	public void setcontentType() {
		inputobject = RestAssured.given().log().all();
		inputobject.contentType(ContentType.JSON);
	}
	@And("Set the Query parameters in Create CR API")
	public void setQueryparam() {
		inputobject.queryParam("sysparm_fields","sys_id,number");
	}
	@When("Send the POST HTTP method for Create CR API")
	public void sendHTTPRequest() {
		outputresponse = inputobject.when().post();
		outputresponse.then().log().all();
		
	}
	@Then("Validate the Create CR API returns statuscode")
	public void validatestatuscode() {
		outputresponse.then().assertThat().statusCode(201);
		
	}
	@And("Validate the response contains the field number with appropriate value")
	public void validateResponseContainsNumber() {
		outputresponse.then().assertThat().body("result.number", Matchers.containsString("CHG"));
		
	}

}
