package basicrestassuredtests;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC007_GET_Request_Authorization {

    @Test
    public void authorizationTest() {

        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

        //Basic Authentication
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        //String username = "ToolsQA";
        authScheme.setUserName("ToolsQA");
        authScheme.setPassword("TestPassword");

        RestAssured.authentication = authScheme;


        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "/");


        //Print response body in the console
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is " + responseBody);

        System.out.println("**************");

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is " + statusCode);
        Assert.assertEquals(statusCode, 200);

    }
}
