package TestFiles.RestAssured_APIs;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import utilities.ExcelReader;

public class PreOrderMeals {

    RequestSpecification requestSpec =
                    given()
                        .baseUri("http://192.168.27.132")
                        .basePath("/cosec/api.svc/v2/user")
                        .auth()
                        .basic("sa", "admin");


    // Call the ExcelReader getTestData method to get test data from the Excel file            
    @DataProvider(name = "userData")
    public Object[][] userData() {
            return ExcelReader.getTestData();
    }

            
    @Test(dataProvider = "userData")

        public void userCreateTest(String tcId, String action, String userId, String name, String expectedStatus, String scenario) {

            String actionValue = action + ";id=" + userId + ";name=" + name + ";";

                Response response =
                        given()
                            .spec(requestSpec)
                            .urlEncodingEnabled(false)
                            .queryParam("action", actionValue)
                            .when()
                            .post();

                System.out.println(tcId + " : " + response.asString());

                Assert.assertEquals(
                        response.statusCode(),
                        Integer.parseInt(expectedStatus));

                Assert.assertTrue(
                        response.asString().contains("saved successfully"),
                        "User creation failed: " + response.asString());
            }

}