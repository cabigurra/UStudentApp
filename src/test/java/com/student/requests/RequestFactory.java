package com.student.requests;

import com.student.tests.TestBase;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestFactory extends TestBase {

    RestClient restClient = new RestClient();

    //@Step("Getting all the student information from the database")
    public Response getAllStudents() {
        Response response = restClient.doGetRequest("");

        return response;
    }

}
