package org.example;

import com.github.javafaker.Faker;
import groovy.util.logging.Slf4j;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PracticGorest {

    RequestSpecification requestSpecification;
    Response response;
    Faker faker = new Faker();


    @Test
    void createNewUsers(){
        String newUser = "{\n" +
                "    \"name\": \""+faker.name().firstName()+"\",\n" +
                "    \"email\": \""+faker.internet().emailAddress()+"\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        response = (Response) requestSpecification
                .body(newUser)
                .post("public/v2/users");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        int id = jsonPath.getInt("id");
        System.out.println(id);
    }


    @Test
    void getAllUsers(){

        RestAssured.baseURI="https://gorest.co.in/";
        requestSpecification =
                given()
                        .header("Authorization", "Bearer " +"65f6e79b21ac624a1bd51bfdefaba46f1fa7a1b6b0ff114ea14b53051da31117")
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON);
        RestAssured.baseURI="https://gorest.co.in/";

        requestSpecification =
                given()
                        .header("Authorization", "Bearer " +"65f6e79b21ac624a1bd51bfdefaba46f1fa7a1b6b0ff114ea14b53051da31117")
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON);

        response = requestSpecification
                .get("public/v2/users");
        response.prettyPrint();

    }

    @Test
    void deleteuser(){
        response = requestSpecification
                .delete("public/v2/users/6819456");
    }




}
