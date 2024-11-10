package org.example;

import com.sun.jdi.request.InvalidRequestStateException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.attribute.standard.RequestingUserName;

import static io.restassured.RestAssured.given;

public class Demo {

    @Test
    void demoo() {
        RestAssured.baseURI = "https://reqres.in/";
        RequestSpecification requestSpecification = given().accept(ContentType.JSON);
        Response response = requestSpecification
                .get("api/users?page=2");
        response.prettyPrint();
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}