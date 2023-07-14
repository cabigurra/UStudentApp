package com.student.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Test;

@Story("This is a CRUD testing story")
public class CrudTest extends TestBase {

    @Story("This is a CRUD testing story")
    @DisplayName("This a test to get all students from the database")
    @Feature("This a test to get all students from the database")
    @Test
    public void getAllStudents() {
        RestAssured.given()
                .when()
                .get()
                .then()
                .log()
                .body()
                .statusCode(200);

    }
}
