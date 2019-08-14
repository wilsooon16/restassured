package TestFramework;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class basics {

	@Test
public void getPlaceAPI()
{
		// TODO Auto-generated method stub

		//BaseURL or Host
		RestAssured.baseURI="https://reqres.in";
		
		given().
		       param("page","2").
		       when().
		       get("/api/users").
		       then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		       body("page",equalTo(2)).and().
		       body("per_page", equalTo(3));
		       
		       
		       /*header("dfd","fsdfds").
		       cookie("dsfs","csder").
		       body()*/
		//Status code of the response
		//Content type 
		//Body
		//Header responses
	
}

}
