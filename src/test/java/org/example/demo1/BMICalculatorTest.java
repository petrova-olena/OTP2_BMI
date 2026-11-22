package org.example.demo1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BMICalculatorTest {

    @Test
    void shouldCalculateNormalBmi() {
        double bmi = BMICalculator.calculate(70, 175);

        assertEquals(22.86, bmi, 0.01);
    }

    @Test
    void shouldCreateCalculator() {
        BMICalculator calculator = new BMICalculator();

        assertNotNull(calculator);
    }

    @Test
    void shouldCalculateOverweightBmi() {
        assertEquals(29.39,
                BMICalculator.calculate(90, 175),
                0.01);
    }

    @Test
    void shouldCalculateUnderweightBmi() {
        assertEquals(15.57,
                BMICalculator.calculate(45, 170),
                0.01);
    }

    @Test
    void shouldCalculateObeseBmi() {
        assertEquals(39.06,
                BMICalculator.calculate(100, 160),
                0.01);
    }
}