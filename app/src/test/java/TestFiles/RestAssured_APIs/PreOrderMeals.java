package TestFiles.RestAssured_APIs;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ExcelReader;

public class PreOrderMeals {

    String baseUri = "http://192.168.27.127";
    String basePath = "/EVERTECT/api.svc/v2/pre-order-meal";

    RequestSpecification requestSpec =
                    given()
                        .baseUri(baseUri)
                        .basePath(basePath)
                        .auth()
                        .basic("Ak1", "admin");

    @DataProvider(name = "userData")
    public Object[][] userData() {
            return ExcelReader.getTestData();
    }

    @Test(dataProvider = "userData")
    public void userCreateTest(
            String TC_ID,
            String action,
            String userId,
            String date,
            String menuid,
            String itemid,
            String quantity,
            String daterange,
            String Scenario, 
            String ExpectedResult
    ) {

        String actionValue =
                action
                + ";user-id=" + userId
                + ";date=" + date
                + ";menu-id=" + menuid
                + ";item-id=" + itemid
                + ";quantity=" + quantity;

        Response response =
                given()
                    .spec(requestSpec)
                    .urlEncodingEnabled(false)
                    .queryParam("action", actionValue)
                    .when()
                    .get();

        String ResponseMessage = response.getBody().asString();
        System.out.println("Expected Message : " + ExpectedResult);
        System.out.println("Actual Message : " + ResponseMessage);
        System.out.println("API : " + Scenario + " : " +baseUri + basePath + "?action=" + actionValue);

        Assert.assertEquals(ResponseMessage, ExpectedResult, "Response mismatch for " + TC_ID);
    }

}