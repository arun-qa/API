Feature: Create CR for service now application

Scenario: TC001 Create CR
Given Set the endpoint for CR in service now application
And Set the Authentication for Service now API
And Set the content-type in Create CR API
And Set the Query parameters in Create CR API
When Send the POST HTTP method for Create CR API
Then Validate the Create CR API returns statuscode
And Validate the response contains the field number with appropriate value



