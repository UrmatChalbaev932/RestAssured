//    Задание
//    Допиши классы Car и Track
//    -  Car принимает в конструктор значение расходы топлива на 100 км;
//    -  принимает первый аргументом расход топлива на 100 км в пересчете на один прицеп;
//    и вторым аргуметом, количество прицепов, Расходы прямо пропорцинален количеству принцепов

package org.example.test;

public class Main {
    public static void main(String[] args) {
      Car bmw = new Car (10);
      Track volvo = new Track (20,2);
      AsphaltRoad asphaltRoad = new AsphaltRoad();

      asphaltRoad.addVehicle(bmw);
      asphaltRoad.addVehicle(volvo);

      asphaltRoad.fillUp(bmw, 15);
      asphaltRoad.drive(bmw, 150);

      asphaltRoad.fillUp(volvo, 42);
      asphaltRoad.drive(volvo, 200);



      asphaltRoad.printVehicleRemainingFuels();
    }
}
