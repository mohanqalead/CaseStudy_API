package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utility {
	
	static Properties properties;
	
	// Method to get the RequestSpecification with common headers
    public static RequestSpecification getRequestSpecification(String requestBody) {
    	
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody);
    }

	public static String getProperty(String key) {
        if (properties == null) {
            try (FileInputStream fis = new FileInputStream("src\\test\\java\\config.properties")) {
                properties = new Properties();
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(key);
    }
	
	public static int getStatusCode(Response response){
		return response.getStatusCode();		
        
    }

    // Method to validate specific key in the response body
    public static String getResponseProperty(Response response, String key) {
        return  response.jsonPath().getString(key);
       
    }
}
