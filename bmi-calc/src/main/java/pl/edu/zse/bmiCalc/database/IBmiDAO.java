package pl.edu.zse.bmiCalc.database;

import pl.edu.zse.bmiCalc.model.Bmi;

import java.util.List;
import java.util.Optional;

public interface IBmiDAO {
    Optional<Bmi> getBmiById(int id);

    List<Bmi> getAllBmi();

    void addBmi(Bmi bmi);
}
