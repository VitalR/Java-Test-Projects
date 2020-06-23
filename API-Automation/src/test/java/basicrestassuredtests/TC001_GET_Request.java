package basicrestassuredtests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GET_Request {

    @Test
    void getweatherDetails(){

        //Specify base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        //Request Object
        RequestSpecification httprequest = RestAssured.given();

        //Response Object
        Response response = httprequest.request(Method.GET, "/Hyderabad");

        //Print response body in the console
        System.out.println("Response Body is " + response.getBody().asString());

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status Code is " + statusCode);
        Assert.assertEquals(statusCode, 201);

        //Status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status Line is " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");


    }
}
