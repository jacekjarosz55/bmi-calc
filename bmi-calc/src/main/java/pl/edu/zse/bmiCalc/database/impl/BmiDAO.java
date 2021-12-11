package pl.edu.zse.bmiCalc.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.zse.bmiCalc.database.IBmiDAO;
import pl.edu.zse.bmiCalc.model.Bmi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BmiDAO implements IBmiDAO {

    @Autowired
    Connection connection;


    @Override
    public Optional<Bmi> getBmiById(int id) {
        String sql = "SELECT * FROM tbmi WHERE id=" + id;
        try {
            Statement statement = this.connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            if(results.next()) {
                Bmi bmi = new Bmi(
                        results.getInt("id"),
                        results.getInt("wzrost"),
                        results.getFloat("waga")
                );
                return Optional.of(bmi);
            }
            else{
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }



    @Override
    public List<Bmi> getAllBmi() {
        String sql = "SELECT * FROM tbmi";
        List<Bmi> res = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            while (results.next()) {
                Bmi bmi = new Bmi(
                results.getInt("id"),
                results.getInt("wzrost"),
                results.getFloat("waga")
                );
                res.add(bmi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public void addBmi(Bmi bmi) {
       String sql = "INSERT INTO tbmi VALUES(null, ?, ?)";
        try {
            PreparedStatement statement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1,bmi.getWzrost());
            statement.setFloat(2,bmi.getWaga());
            statement.executeUpdate();

            ResultSet results = statement.getGeneratedKeys();
            results.next();
            bmi.setId(results.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
