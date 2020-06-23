package basicrestassuredtests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_POST_Request {

    @Test
    void registrationSuccessful() {

        //Specify base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        //Request Object
        RequestSpecification httprequest = RestAssured.given();

        //Request payload sending along with post request
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "JohnZXC");
        requestParams.put("LastName", "DoeZXC");
        requestParams.put("UserName", "JohnZXC_DoeZXC");
        requestParams.put("Password", "JD@&123");
        requestParams.put("Email", "JohnZXC_DoeZXC@gmail.com");

        httprequest.header("Content-Type", "application/json");
        httprequest.body(requestParams.toJSONString()); //Attach above data to the request

        //Response Object
        Response response = httprequest.request(Method.POST, "/register");

        //Validation part of Test:
        //Print response body in the console
        System.out.println("Response Body is " + response.getBody().asString());

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is " + statusCode);
        Assert.assertEquals(statusCode, 201);

        String successCode = response.jsonPath().get("SuccessCode");
        System.out.println("Success Code is " + successCode);
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");

        String message = response.jsonPath().get("Message");
        System.out.println("Message is " + successCode);
        Assert.assertEquals(message, "Operation completed successfully");


    }
}
