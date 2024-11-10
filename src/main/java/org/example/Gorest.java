package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.github.javafaker.Stock;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Gorest {

    @Test
    void gorest() throws JsonProcessingException {
        RestAssured.baseURI="https://gorest.co.in/";

        // RestAssured.baseURL="https://gorest.co.in/";

        RequestSpecification requestSpecification = given()
                .header("Authorizantion", "Bearer " +"65f6e79b21ac624a1bd51bfdefaba46f1fa7a1b6b0ff114ea14b53051da31117")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON);
        // requestSpecification requestSpecification = given()
        //      .header("Authorizantion", "Bearer" + "asdf34rqwer234e22342342314")
        //      .contentType(ContentType.JSON):
        //      .accept(ContentType.JSON);



        Response response = requestSpecification
                .get("public/v2/users");




        JsonPath jsonPath = response.jsonPath();

        String name = jsonPath.getString("[8].name");
        System.out.println(name);
        Assert.assertEquals(name,"Preity Abbot");


        List< Student> usersPayLoad = ObjectConverter.convertJsonArrayToListOfObjects(response.prettyPrint(), Student[].class);
        usersPayLoad.forEach(System.out:: println);
//        Student(id=6819215, name=Shivakari Guneta, email=guneta_shivakari@champlin.example, gender=female, status=active)
//        Student(id=6819214, name=Archan Kaniyar, email=kaniyar_archan@renner-nader.test, gender=male, status=inactive)
//        Student(id=6819213, name=Yoginder Gandhi, email=yoginder_gandhi@lindgren-kuhlman.test, gender=female, status=inactive)
//        Student(id=6819212, name=Gajadhar Varma, email=gajadhar_varma@doyle-altenwerth.example, gender=female, status=inactive)
//        Student(id=6819211, name=Eshana Patel, email=eshana_patel@haag-cassin.example, gender=male, status=inactive)
//        Student(id=6819210, name=Vijay Gupta, email=gupta_vijay@kuphal-flatley.example, gender=female, status=inactive)
//        Student(id=6819209, name=Bilva Mukhopadhyay, email=mukhopadhyay_bilva@schultz.test, gender=male, status=inactive)
//        Student(id=6819208, name=Chatura Jain, email=jain_chatura@miller.example, gender=female, status=active)
//        Student(id=6819207, name=Amodini Somayaji, email=somayaji_amodini@miller.test, gender=male, status=inactive)
//        Student(id=6819206, name=Gov. Vimala Nehru, email=vimala_gov_nehru@treutel.test, gender=male, status=inactive)


        response.prettyPrint();
    }


    @Test
    void createNewUsers() throws JsonProcessingException {
        String str = "{\n" +
                "    \"name\": \"Jonh Down\",\n" +
                "    \"email\": \"JonhDown@walter-krajcik.example\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();

//        Student student = Student.builder()
//                .name("Max")
//                .email("qwer@asdf.com")
//                .gender("male")
//                .status("active")
//                .build();
//
//        String studentPayLoad = objectMapper.writeValueAsString(student);

        Faker faker = new Faker();

        Student student = Student.builder()
                .name(faker.name().firstName())
                .email(faker.internet().emailAddress())
                .gender("male")
                .status("active")
                .build();
        String studentPayLoad = ObjectConverter.convertJavaObjectToJsonObject(student);
        System.out.println(studentPayLoad);
//        {
//            "id": 6821424,
//                "name": "Hwa",
//                "email": "chassidy.crooks@gmail.com",
//                "gender": "male",
//                "status": "active"
//        }





        RestAssured.baseURI="https://gorest.co.in/";
        RequestSpecification requestSpecification = given()
                .header("Authorization", "Bearer " +"65f6e79b21ac624a1bd51bfdefaba46f1fa7a1b6b0ff114ea14b53051da31117")
                .accept(ContentType.JSON) // формат отправки
                .contentType(ContentType.JSON) // формат приема
                .body(studentPayLoad); // отправка боди

        Response response = requestSpecification
                .post("public/v2/users"); // Используйте конечную точку запроса вместо дополнительных путей, если они не нужны

        response.prettyPrint();
//        {
//            "id": 6821406,
//                "name": "Max",
//                "email": "qwer@asdf.com",
//                "gender": "male",
//                "status": "active"
//
        }



    public static void main(String[] args) {


            ArrayList<String> list = new ArrayList<>(List.of("1","2","3","4","5","6"));
            for(int i = 0; i<list.size(); i++){
                list.remove(i);
            }
            System.out.println(list);

    }
}
// Select
// product_id,
// product_name,
// SUM(price * quantity) as total_value
// FROM
// orders
// GROUP BY
// product_id
// product_name
// ORDER BY
// total_value DESC
// LIMIT 1