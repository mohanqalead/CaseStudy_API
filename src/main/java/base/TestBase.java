package base;

import org.testng.annotations.BeforeSuite;


import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.Utility;

public class TestBase {
	
	@BeforeSuite
	public void suiteSetup() {
	
		RestAssured.baseURI = Utility.getProperty("baseurl");
		
	}
	
	

}
