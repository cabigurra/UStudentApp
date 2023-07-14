package com.student.tests;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;
import com.student.tags.Regression;
import com.student.tags.Smoke;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;

@Story("This is a CRUD testing story")
public class CrudTest extends TestBase {

    RequestFactory requests = new RequestFactory();

    @Category(Smoke.class)
    @Story("This is a CRUD testing story")
    @DisplayName("This a test to get all students from the database")
    @Feature("This a test to get all students from the database")
    @Tag("Smoke")
    @Test
    public void getAllStudents() {
        requests.getAllStudents()
                .then()
                .spec(SpecificationFactory.getGenericResponseSpec())
                .statusCode(200);
    }

    @Category({Regression.class, Smoke.class})
    @Story("This is a CRUD testing story")
    @DisplayName("Test to create & verify a new student")
    @Feature("Test to create & verify a new student")
    @Tag("Regression, Smoke")
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
