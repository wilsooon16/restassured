package TestFramework;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import googleAPIs.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class basics3 {
	  private static Logger log =LogManager.getLogger(basics3.class.getName());
	
	Properties prop=new Properties();
	
	@BeforeTest
	public void getData() throws IOException
	{	
		
		//C:\work\RESTAssuredTest\env.properties
		FileInputStream fis=new FileInputStream("/Users/Nakama/Documents/RESTAssuredTest/env.properties");
		prop.load(fis);
		

	}

	@Test
	public void AddandDeletePlace()
	{
		
		//Task 1- Grab the response
		
		log.info("Host information"+prop.getProperty("HOST"));
		RestAssured.baseURI= prop.getProperty("HOST");
		Response res=given().
		header("Content-Type","application/json").
		body(payLoad.getRegiser()).
		when().
		post(resources1.placePostData()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("token",equalTo("QpwL5tke4Pnpja7X4")).
		extract().response();
		// Task 2- Grab the Place ID from response
		
		String responseString=res.asString();
		log.info(responseString);
		JsonPath js= new JsonPath(responseString);
		String token=js.get("token");
		log.info(token);
		
		
		//Task 3 place this place id in the Delete request
		given().
		header("Content-Type","application/json").
		body("{\r\n" + 
				"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
				"    \"password\": \"cityslicka\"\r\n" + 
				"}").
		when().
		post("/api/login").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("token",equalTo("QpwL5tke4Pnpja7X4"));
		
		
	}
}
