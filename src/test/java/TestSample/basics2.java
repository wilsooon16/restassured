package TestSample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import user.post.model.*;

public class basics2 {
	@Test
    public void testCreateUser() {
        // Base URL for Reqres API
        RestAssured.baseURI = "https://reqres.in/api";

        // Create a new user object
        User user = new User();
        user.setName("John Doe");
        user.setJob("Software Engineer");

        // Send a POST request to create a new user
        int statusCode = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/users")
                .getStatusCode();

        // Check the response status code
        if (statusCode == 201) {
            System.out.println("User created successfully!");
        } else {
            System.out.println("Failed to create user. Status code: " + statusCode);
        }
    }
}




