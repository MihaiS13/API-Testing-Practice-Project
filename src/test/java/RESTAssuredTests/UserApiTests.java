package RESTAssuredTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UserApiTests extends BaseTest {

    int userId = 1; // Using existing user ID since dummy API doesn't persist changes

    // Test to create a new user (POST request)
    @Test(priority = 1)
    public void testCreateUser() {
        String body = "{ \"firstName\": \"Mihai\", \"lastName\": \"S\", \"age\": 26 }";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/users/add")
                .then()
                .extract().response();

        assertEquals(response.statusCode(), 201);
        userId = response.jsonPath().getInt("id");
        System.out.println("Created user with ID: " + userId);
    }

    // Test to retrieve user details (GET request)
    @Test
    public void testGetUser() {
        Response response = given()
                .when()
                .get("/users/" + userId)
                .then()
                .extract().response();

        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getInt("id"), userId);
    }

    // Test to update user information (PUT request)
    @Test
    public void testUpdateUser() {
        String body = "{ \"firstName\": \"MihaiUpdated\" }";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("/users/" + userId)
                .then()
                .extract().response();

        assertEquals(response.statusCode(), 200);
    }

    // Test to delete a user (DELETE request)
    @Test
    public void testDeleteUser() {
        Response response = given()
                .when()
                .delete("/users/" + userId)
                .then()
                .extract().response();

        assertEquals(response.statusCode(), 200);

    }
}