package org.example;

import com.google.gson.Gson;

public class GsonDemo {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Car mers = new Car("Mers", "S500", 4, "Black");
        System.out.println(mers);//Car(brand=Mers, model=S500, door=4, color=Black)

        String mersPayLoad = gson.toJson(mers);
        System.out.println(mersPayLoad);//{"brand":"Mers","model":"S500","door":4,"color":"Black"}


        String userJsonPayLoad = "{\n" +
                "    \"name\": \"Jonh Down\",\n" +
                "    \"email\": \"JonhDown@walter-krajcik.example\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        System.out.println(userJsonPayLoad);
//        {
//        "name": "Jonh Down",
//                "email": "JonhDown@walter-krajcik.example",
//                "gender": "male",
//                "status": "active"
//    }

        Student student = gson.fromJson(userJsonPayLoad, Student.class);
        System.out.println(student);//Student(id=0, name=Jonh Down, email=JonhDown@walter-krajcik.example, gender=male, status=active)
    }
}
