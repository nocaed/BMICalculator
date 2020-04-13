package com.example.bmicalculator;

public class BMICalculator {
    private CalculationMode mode; // holds the unit system that the calculator uses

    private final double POUND_MULTIPLIER = 703.0; // constant that the weight is multiplied by for
                                                   // BMI calculation in customary units

    /**
     * Constructor for BMICalculator.
     * @param mode The unit system (customary/metric) used for calculation
     */
    public BMICalculator(CalculationMode mode) {
        this.mode = mode;
    }

    /**
     * Calculates BMI.
     * @param weight The weight of the user
     * @param height The height of the user
     * @return The BMI of the user
     */
    public double calculateBMI(double weight, double height) {
        // Sets the divisor of the formula
        double newHeight = Math.pow(height, 2.0);
        // holds the divident of the formula
        double newWeight;

        // multiply weight by the constant if customary units
        if(mode == CalculationMode.CUSTOMARY)
            newWeight = weight * POUND_MULTIPLIER;
        // otherwise dont multiply
        else
            newWeight = weight;

        // return the bmi
        return newWeight / newHeight;
    }
}
