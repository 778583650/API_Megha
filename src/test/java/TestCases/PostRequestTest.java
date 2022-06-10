package TestCases;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PostRequestTest {
    @Test
    public void createUser() throws IOException {
//        String body = Files.readString(Path.of(System.getProperty("user.dir") + "\\src\\test\\resources\\api_test_data\\CreateUserJsonBody.json"), StandardCharsets.US_ASCII);
//
//        Response response = APIUtils.postRequest(String key, String value);
//        Assert.assertEquals(response.getStatusCode(),201,"status code mismatch");


//        specify base URI:
        RestAssured.baseURI = "https://reqres.in/api";

//                Represents request object
        RequestSpecification httprequest = RestAssured.given();
//        request payload sending along with post request
        JSONObject requestParam=new JSONObject();
        requestParam.put("name","morpheus");
        requestParam.put("job","leader");
        requestParam.put("id","996");
        requestParam.put("createdAt","2022-06-09T14:57:15.846Z");
        httprequest.header("Content-Type","application/json");
        httprequest.body(requestParam.toString());
        Response response = httprequest.request(Method.POST, "/users");

//                print response in console
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is=" + responseBody);
//        status code validation
        int statusCode= response.getStatusCode();
        System.out.println("Status Code is=" +statusCode );
        Assert.assertEquals(statusCode,201);

    }
}















