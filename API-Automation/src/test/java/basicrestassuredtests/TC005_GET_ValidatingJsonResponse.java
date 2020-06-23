package basicrestassuredtests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_GET_ValidatingJsonResponse {

    @Test
    void getWeatherDetails(){

        //Specify base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        //Request Object
        RequestSpecification httprequest = RestAssured.given();

        //Response Object
        Response response = httprequest.request(Method.GET, "/Hyderabad");

        //Print response body in the console
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is " + responseBody);

        Assert.assertTrue(responseBody.contains("Hyderabad"));




        /*
        //Print all headers
        Headers allHeaders = response.headers();  //Capture all headers from response

        for(Header header: allHeaders) {
            System.out.println(header.getName() + "   " + header.getValue());
        }
        */

    }
}
