package org.example.test;

public class Track extends Vehicle {

    private int trackCount;

    public Track(double fuelConsumption, int trackCount) {
        super(fuelConsumption);
        this.trackCount = trackCount;
    }

    @Override
    void drive(double distance) {
        if (distance <= 0) {
            System.out.println("Stop!: distance<=0");
        } else {
            double fuelNeeded = (distance / 100) * fuelConsumption + trackCount;
            if (fuelLevel < fuelNeeded) {
                System.out.println("Stop! fuelNeeded: " + (fuelNeeded - fuelLevel));
            } else {
                fuelLevel -= fuelNeeded;
                System.out.println("Go!");
            }
        }
    }
}