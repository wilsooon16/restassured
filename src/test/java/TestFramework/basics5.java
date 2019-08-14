package TestFramework;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;



public class basics5 {

	@Test
public void extractingNamesAPI()
{
		// TODO Auto-generated method stub

		//BaseURL or Host
		RestAssured.baseURI="https://reqres.in";
		
		Response res=given().
			   header("Content-Type","application/json").log().all().
		       when().
		       get("/api/unknown").
		       then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		       body("data[0].name",equalTo("cerulean")).and().
		       body("data[0].color", equalTo("#98B2D1")).and().
		       extract().response();
		   JsonPath js= ReusableMethods.rawToJson(res);
		   
		   int count=js.get("data.size()");
		   for(int i=0;i<count;i++)
		   {
			  System.out.println(js.get("data["+i+"].name"));
		   }
		   System.out.println(count);
		       
		       
		       /*header("dfd","fsdfds").
		       cookie("dsfs","csder").
		       body()*/
		//Status code of the response
		//Content type 
		//Body
		//Header responses
	
}

}
