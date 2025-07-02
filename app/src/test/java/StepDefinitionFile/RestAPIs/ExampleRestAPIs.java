package StepDefinitionFile.RestAPIs;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import PageObjectFile.PageObject_RestAPIs;
import java.util.HashMap;

public class ExampleRestAPIs {

    String id;
    PageObject_RestAPIs pageObjectRestAPIs = new PageObject_RestAPIs();

    @Test(priority = 1)
    public void Test01() {
//        pageObjectRestAPIs.UserGet();

        //Parent kind of
        given()
                .when().get("https://reqres.in/api/users/2")
                .then().statusCode(200).body("data.id", equalTo(2)).log().body();
    }

    @Test(priority = 2)
    public void Test02() {
//        pageObjectRestAPIs.CreateUser();

        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Akshay");
        data.put("job", "trainer");

        Response response = given().header("x-api-key", "reqres-free-v1").contentType("application/json").body(data)
                .when().post("https://reqres.in/api/users");

        // Log and validate
        System.out.println("Response: " + response.asString());
        Assert.assertEquals(response.getStatusCode(), 201, "User creation failed");

        // Extract ID from response
        String extractedId = response.jsonPath().getString("id");
        Assert.assertNotNull(extractedId, "ID not found in response!");

        id = extractedId;
        System.out.println("Created User ID: " + id);

    }

    @Test(priority = 3)
    public void Test03() {
//        pageObjectRestAPIs.UpdateUser();

        // Ensure ID is set before updating
        Assert.assertNotNull(id, "ID is null. Test02 might have failed.");

        // PUT update the user with new values
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "john");
        data.put("job", "teacher");

        given().header("x-api-key", "reqres-free-v1").contentType("application/json").body(data)

                .when().put("https://reqres.in/api/users/" + id)

                .then().statusCode(200).log().all();
    }

}
