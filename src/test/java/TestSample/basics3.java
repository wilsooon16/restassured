package TestSample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import user.get.model.User;


public class basics3 {
	@Test
    public void testGetUser() {
        // Base URL for Reqres API
        RestAssured.baseURI = "https://reqres.in/api";

        // User ID to retrieve
        int userId = 2;

        // Send a GET request to retrieve a user by ID and store directly in the User POJO
        User user = RestAssured.given()
                .when().log().all()
                .get("/users/" + userId)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .as(User.class);

        // Assert user details
        System.out.println(user);
        assertUserDetails(user, userId);
    }

    // Helper method to assert user details
    private static void assertUserDetails(User user, int expectedUserId) {
        // Perform assertions as per your requirements
        // For example:
       
        System.out.println("User ID: " + user.getData().getId());
        System.out.println("User Name: " + user.getData().getFirst_name());
        System.out.println("User Avatar: " + user.getData().getAvatar());
        assert user.getData().getId() == expectedUserId : "User ID mismatch!";
    }
}