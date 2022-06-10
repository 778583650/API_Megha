package Utilities;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class API_Utils {
    public static Properties configs;
    public static RequestSpecification request;

    public static Response response;

    public static void readAPIConfigs() throws IOException {
        configs = new Properties();
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configs.properties");
        configs.load(fs);

    }

    public static Response postRequest(String key, String value) {
        request.header("Content-Type", "application/json");
        request.body(value);
        response =request.post(key);

        return response;
}
    public static Response getRequest(String key) {
        request.header("Content-Type", "application/json");
        response =request.get(key);
        return response;


    }


}