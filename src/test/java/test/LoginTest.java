package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import config.RequestBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.Utility;

public class LoginTest extends TestBase{
	
	
	@Test
    public void loginWithValidUser() {
        System.out.println(RestAssured.baseURI);
        try {
        	Response response = Utility.getRequestSpecification(RequestBody.validLoginCredentials()).log().all()
                    .post("/login")
                    .then().log().all()
                    .extract().response();
            
            // Assertions
            Assert.assertEquals(Utility.getStatusCode(response), 200, "HTTP Status Code");
            Assert.assertNotNull(Utility.getResponseProperty(response, "token"), "Token should not be null");
        }catch (Exception e) {
			
        	e.printStackTrace();
		}        
    }
	
	@Test
	public void loginWithInValidUser() {
		try {
			Response response = Utility.getRequestSpecification(RequestBody.inValidLoginCredentials()).log().all()
                    .post("/login")
                    .then().log().all()
                    .extract().response();
            
            // Assertions
            Assert.assertEquals(Utility.getStatusCode(response), 400, "HTTP Status Code");
            Assert.assertEquals(Utility.getResponseProperty(response, "error"), "user not found");
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void loginWithNoPassword() {
		try {
			Response response = Utility.getRequestSpecification(RequestBody.missingPassword()).log().all()
                    .post("/login")
                    .then().log().all()
                    .extract().response();
            
            // Assertions
            Assert.assertEquals(Utility.getStatusCode(response), 400, "HTTP Status Code");
            Assert.assertEquals(Utility.getResponseProperty(response, "error"), "Missing password");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void loginWithNoEmail() {
		try {
			Response response = Utility.getRequestSpecification(RequestBody.missingEmail()).log().all()
                    .post("/login")
                    .then().log().all()
                    .extract().response();
            
            // Assertions
            Assert.assertEquals(Utility.getStatusCode(response), 400, "HTTP Status Code");
            Assert.assertEquals(Utility.getResponseProperty(response, "error"), "Missing email or username");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
