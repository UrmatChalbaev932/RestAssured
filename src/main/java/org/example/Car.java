package org.example;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    private String brand;
    private String model;
    private int door;
    private String color;

    public Car(int i) {
    }
}
