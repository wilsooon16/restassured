package TestFramework;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import googleAPIs.payLoad;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class basics2 {

	Properties prop=new Properties();

	@BeforeTest
	public void getData() throws IOException
	{	
		
		//C:\work\RESTAssuredTest\env.properties
		FileInputStream fis=new FileInputStream("/Users/nakama/Documents/RESTAssuredTest/env.properties");
		prop.load(fis);
		

	}
	
	@Test
	public void createPlaceAPI()
	{
		RestAssured.baseURI=prop.getProperty("HOST");
		given().
		header("Content-Type","application/json").
		body(payLoad.createPlaceData()).
		when().
		post("/api/users").
		then().assertThat().statusCode(201).and().contentType(ContentType.JSON).and().
		body("name",equalTo("morpheus"));
		
	// Create a place =response (place id)
		
		// delete Place = (Request - Place id)	
		

	}
}
