package basicrestassuredtests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_GET_Request {

    @Test
    void googleMapTest(){

        //Specify base URI
        RestAssured.baseURI = "https://maps.googleapis.com";
        //Request Object
        RequestSpecification httprequest = RestAssured.given();

        //Response Object
        Response response = httprequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

        //Print response body in the console
        System.out.println("Response Body is " + response.getBody().asString());

        //Validating headers
        String contentType = response.header("Content-Type"); //Capture details of Content-Type
        System.out.println("Content-Type is " + contentType);
        Assert.assertEquals(contentType, "application/xml; charset=UTF-8");

        String contentEncoding = response.header("Content-Encoding"); //Capture details of Content-Encoding
        System.out.println("Content-Encoding is " + contentEncoding);
        Assert.assertEquals(contentEncoding, "gzip");

        String server = response.header("Server"); //Capture details of Server
        System.out.println("Server is " + server);
        Assert.assertEquals(server, "scaffolding on HTTPServer2");

    }
}
