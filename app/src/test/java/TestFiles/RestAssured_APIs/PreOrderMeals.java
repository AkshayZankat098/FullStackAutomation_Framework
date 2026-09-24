package TestFiles.RestAssured_APIs;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import groovy.transform.builder.InitializerStrategy.SET;

import static io.restassured.RestAssured.given;

import java.util.Map;

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
                public void userCreateTest(Map<String, String> data) {

                String TC_ID          = data.get("TC_ID");
                String action        = data.get("action");
                String Scenario      = data.get("Scenario");
                String ExpectedResult      = data.get("ExpectedResult");

                String actionValue = action;

                if (data.containsKey("user-id"))
                actionValue += ";user-id=" + data.get("user-id");

                if (data.containsKey("date-range"))
                actionValue += ";date-range=" + data.get("date-range");

                if (data.containsKey("date"))
                actionValue += ";date=" + data.get("date");

                if (data.containsKey("menu-id"))
                actionValue += ";menu-id=" + data.get("menu-id");

                if (data.containsKey("item-id"))
                actionValue += ";item-id=" + data.get("item-id");

                if (data.containsKey("quantity"))
                actionValue += ";quantity=" + data.get("quantity");

                String SET = "Test Cases SET";
                String GET = "Test Cases GET";
                String DELETE = "Test Cases DELETE";

        Response response = given()
                .spec(requestSpec)
                .urlEncodingEnabled(false)
                .queryParam("action", actionValue)
                .when()
                .request(GET.contains("GET") ? "GET" :
                SET.contains("SET") ? "POST" :
                DELETE.contains("DELETE") ? "DELETE" :
                "GET");


        String ResponseMessage = response.getBody().asString();
        System.out.println("Expected Message : " + ExpectedResult);
        System.out.println("Actual Message : " + ResponseMessage);
        System.out.println("API : " + Scenario + " : " +baseUri + basePath + "?action=" + actionValue);

        Assert.assertEquals(ResponseMessage, ExpectedResult, "Response mismatch for " + TC_ID);
    }

}