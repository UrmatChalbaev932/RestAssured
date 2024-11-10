package org.example.test;

public abstract class Vehicle {
    double fuelConsumption;
    double fuelLevel =0;

    public Vehicle(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    void fillUp(double liters) {
        if(liters>0) {
            this.fuelLevel += liters;
        } else {
            System.out.println("Stop! liters<=0");
        }
    }

    void drive(double distance){
        if(distance<=0){
            System.out.println("Stop!: distance<=0");
        } else {
            double fuelNeeded = (distance / 100) * fuelConsumption;
            if (fuelLevel < fuelNeeded) {
                System.out.println("Stop! fuelNeeded: " + (fuelNeeded - fuelLevel));
            } else {
                fuelLevel -= fuelNeeded;
                System.out.println("Go!");
            }
        }
    }

    double remainingFuel(){
        return fuelLevel;
    };

}
