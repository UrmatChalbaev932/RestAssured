package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDemo {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car lexus = new Car("Lexus", "RX350", 4, "Black");
        String lexusJsonPayLoad = objectMapper.writeValueAsString(lexus);
        System.out.println(lexusJsonPayLoad);//{"brand":"Lexus","model":"RX350","door":4,"color":"Black"}


        String userJsonPayLoad = "{\n" +
                "    \"name\": \"Jonh Down\",\n" +
                "    \"email\": \"JonhDown@walter-krajcik.example\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        Student student = objectMapper.readValue(userJsonPayLoad, Student.class);
        System.out.println(student); //Student(id=0, name=Jonh Down, email=JonhDown@walter-krajcik.example, gender=male, status=active)
    }
}
