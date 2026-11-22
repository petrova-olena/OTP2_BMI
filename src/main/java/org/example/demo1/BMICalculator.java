package org.example.demo1;

public class BMICalculator {

    public static double calculate(double weight, double heightCm) {
        double height = heightCm / 100.0;
        return weight / (height * height);
    }
}