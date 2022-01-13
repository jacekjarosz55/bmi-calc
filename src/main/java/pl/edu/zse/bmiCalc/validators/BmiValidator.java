package pl.edu.zse.bmiCalc.validators;

import pl.edu.zse.bmiCalc.exceptions.ValidationException;

public class BmiValidator {
    public static void validateWzrost(int wzrost){
        if (wzrost < 0) throw new ValidationException("Wzrost has to be higher than zero!");
    }
    public static void validateWaga(float waga){
        if (waga < 0) throw new ValidationException("Waga has to be higher than zero!");
    }
}
