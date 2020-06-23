package basicrestassuredtests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC006_GET_ExtractValuesOfEachNodeInJson {

    @Test
    void getWeatherDetails(){

        //Specify base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        //Request Object
        RequestSpecification httprequest = RestAssured.given();

        //Response Object
        Response response = httprequest.request(Method.GET, "/Hyderabad");


        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.get("City"));
        System.out.println(jsonPath.get("Temperature"));
        System.out.println(jsonPath.get("Humidity"));
        System.out.println(jsonPath.get("WeatherDescription"));
        System.out.println(jsonPath.get("WindSpeed"));
        System.out.println(jsonPath.get("WindDirectionDegree"));

        Assert.assertEquals(jsonPath.get("Temperature"), "27.2 Degree celsius");


        System.out.println("*********");
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
