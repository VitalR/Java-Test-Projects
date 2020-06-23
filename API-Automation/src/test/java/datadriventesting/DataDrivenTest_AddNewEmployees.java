package datadriventesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataDrivenTest_AddNewEmployees {

    @Test(dataProvider = "empdataprovider")
    public void postNewEmployees(String ename, String esalary, String eage) {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        RequestSpecification httprequest = RestAssured.given();

        //Here we create data which we can send along with the post request
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", ename);
        requestParams.put("salary", esalary);
        requestParams.put("age", eage);

        //Add a header stating the Request body is a JSON
        httprequest.header("Content-Type", "application/json");

        //Add the JSON to the body of the request
        httprequest.body(requestParams.toJSONString());

        //Post request
        Response response = httprequest.request(Method.POST, "/create");

        //Capture response body to perform validation
        String responseBody = response.getBody().asString();

        System.out.println("Response Body is " + responseBody);

        Assert.assertEquals(responseBody.contains(ename), true);
        Assert.assertEquals(responseBody.contains(esalary), true);
        Assert.assertEquals(responseBody.contains(eage), true);

        int statuscode = response.statusCode();
        Assert.assertEquals(statuscode, 200);
    }


    @DataProvider(name = "empdataprovider")
    Object[][] getEmpData() throws IOException {

        //Read data from Excel
        String path = "/Users/agileengine/Projects/RestAssuredAutomation/src/test/java/datadriventesting/empdata.xls";

        int rownum = XLUtility.getRowCount(path, "Sheet1");
        int colcount = XLUtility.getCellCount(path, "Sheet1", 1);

        Object[][] empData = new Object[rownum][colcount];
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                empData[i - 1][j] = XLUtility.getCellData(path, "Sheet1", i, j);
            }
        }


        //Object[][] empData = { {"zxc123", "3000", "30"}, {"asd123", "4000", "35"}, {"qwe123", "4500", "40"}};
        return empData;
    }
}
