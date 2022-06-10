package TestCases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetRequestTest {
    @Test
    public void getAllUsers(){


//        specify base URI:
        RestAssured.baseURI = "https://reqres.in/";

//                Represents request object
        RequestSpecification httprequest = RestAssured.given();
//                response object
        Response response = httprequest.request(Method.GET, "/api/users?page=2");
//                print response in console
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is=" + responseBody);
//        status code validation
        int statusCode= response.getStatusCode();
        System.out.println("Status Code is=" +statusCode );
        Assert.assertEquals(statusCode,200);
//        status line verification
        String StatusLine=response.getStatusLine();
        System.out.println("Status Line is=" + StatusLine);
    }
}