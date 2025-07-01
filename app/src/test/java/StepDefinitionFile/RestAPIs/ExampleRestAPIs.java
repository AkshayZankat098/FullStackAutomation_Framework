package StepDefinitionFile.RestAPIs;

import io.cucumber.java.en.Given;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import PageObjectFile.PageObject_RestAPIs;

import java.util.HashMap;

public class ExampleRestAPIs {

    int id;

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

        HashMap data = new HashMap();
        data.put("name", "Akshay");
        data.put("job", "trainer");

        id = given().contentType("application/json").body(data)

                .when().post("https://reqres.in/api/users").jsonPath().getInt("id");
    }

    @Test(priority = 3)
    public void Test03() {
//        pageObjectRestAPIs.UpdateUser();

        HashMap data = new HashMap();
        data.put("name", "john");
        data.put("job", "teacher");

        given().contentType("application/json").body(data)

                .when().put("https://reqres.in/api/users/" + id)

                .then().statusCode(200).log().all();
    }


}
