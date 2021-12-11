package pl.edu.zse.bmiCalc.services;

import pl.edu.zse.bmiCalc.model.Bmi;

import java.util.Optional;

public interface IBmiService {
    void addBmi(Bmi bmi);
    Optional<Bmi> getBmiById(int id);
    double calculateBmi(Bmi bmi);
}
