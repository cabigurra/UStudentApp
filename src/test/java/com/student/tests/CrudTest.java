package com.student.tests;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Story("This is a CRUD testing story")
public class CrudTest extends TestBase {

    RequestFactory requests = new RequestFactory();

    @Story("This is a CRUD testing story")
    @DisplayName("This a test to get all students from the database")
    @Feature("This a test to get all students from the database")
    @Test
    public void getAllStudents() {
        requests.getAllStudents()
                .then()
                .log()
                .body()
                .statusCode(200);

    }

    @Story("This is a CRUD testing story")
    @DisplayName("Test to create & verify a new student")
    @Feature("Test to create & verify a new student")
    @Test
    public void createNewStudent() {
        Faker fakeData = new Faker();

        String firstName = fakeData.name().firstName();
        String lastName  = fakeData.name().lastName();
        String email     = fakeData.internet().emailAddress();
        String programme = "ComputerScience";

        List<String> courses = new ArrayList<String>();
        courses.add("C++");
        courses.add("Java");

        requests.createNewStudent("", firstName, lastName, email, programme, courses)
                .then()
                .statusCode(201);
    }
}
