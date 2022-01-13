package pl.edu.zse.bmiCalc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.zse.bmiCalc.database.IBmiDAO;
import pl.edu.zse.bmiCalc.model.Bmi;
import pl.edu.zse.bmiCalc.services.IBmiService;

import java.util.Optional;

@Service
public class BmiService implements IBmiService {

    @Autowired
    IBmiDAO bmiDAO;


    @Override
    public void addBmi(Bmi bmi) {
        bmiDAO.addBmi(bmi);
    }

    @Override
    public Optional<Bmi> getBmiById(int id) {
        return bmiDAO.getBmiById(id);
    }

    @Override
    public double calculateBmi(Bmi bmi) {
        float waga = bmi.getWaga();
        double wzrost = bmi.getWzrost() / 100.0;
        return waga / Math.pow(wzrost,2);
    }
}
