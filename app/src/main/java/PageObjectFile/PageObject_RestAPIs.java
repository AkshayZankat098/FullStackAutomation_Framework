package PageObjectFile;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PageObject_RestAPIs {
    int id;

    /*
     src/main/java: Contains core development code such as
                 - Utility classes (API, WebDriver, ConfigLoader)
                 - Page Object Model (POM) classes for UI automation
                 - Reusable business logic methods
     src/main/resources: Stores supporting files needed by development code,
                      - Configuration files (config.properties, log4j.xml)
                      - Excel files for test data
                      - JSON/XML schemas, data templates
     src/test/java: Contains all test-related code like:
                 - TestNG test classes
                 - Cucumber step definitions
                 - Test runners (TestNG + Cucumber glue code)
                 - Hooks (Before/After test setup and teardown)
     src/test/resources: Stores test-related resource files such as
                 - Cucumber `.feature` files for BDD
                 - Test-specific data sets
                 - Mock response files, test payloads


    RestAPI: Is an API/library through which we can automate RestAPI.
    Rest-assured by default support gherkin language

    List of HTTPS methods in APIs:
        - GET (Read):	Retrieve data from the server (read-only).
        - POST (New Create or SET):	Send data to the server to create a new resource.
        - PUT (Update - Full update of a resource):	Update an existing resource completely.
        - PATCH (Update - Partial update of a resource):	Update part of an existing resource (partial update).
        - DELETE (Delete):	Remove a resource from the server.

    gherkin main methods:
         1) Given() Pre-Require: content type, set cookies, add auth, add param, set headers info etc.
         2) When() Step-Action: get, post, put, delete
         3) Then() Expected-Result: validate status code, extract response, extract header cookies and response body.

         Get users: https://reqres.in/api/users/2
         Post (Create) user: https://reqres.in/api/users
            Request body: Data sent by the client to the server in an HTTP request, typically in POST, PUT, or PATCH methods, used to create or update a resource.
            {
                "name": "morpheus",
                "job": "leader"
            }

        Update user: https://reqres.in/api/users/2
        Request body:
        {
            "name": "morpheus",
            "job": "leader"
        }

        Delete user: https://reqres.in/api/users/userid

        Base URL: root address of the API server used to send requests. (https://reqres.in)
        End points: Specific paths appended to the base URL to access particular resources. (/api/users/2)
        Request body: data sent by the client to the server in an HTTP request to create or update a resource.
        Response body: data returned by the server in response to a client's request.
        Validation point in a then section: Used to assert expected outcomes like status code, response body, headers after an API call. (statusCode(200))

    */

    public void UserGet() {

        //Parent kind of
        given()
                .when().get("https://reqres.in/api/users/2")
                .then().statusCode(200).body("data.id", equalTo(2)).log().body();
    }

    public void CreateUser() {

        HashMap data = new HashMap();
        data.put("name", "pavan");
        data.put("job", "trainer");

        id = given().contentType("application/json").body(data)

                .when().post("https://reqres.in/api/users").jsonPath().getInt("id");
    }

    public void UpdateUser() {
        HashMap data = new HashMap();
        data.put("name", "john");
        data.put("job", "teacher");

        given().contentType("application/json").body(data)

                .when().put("https://reqres.in/api/users/" + id)

                .then().statusCode(201).log().all();
    }


}
