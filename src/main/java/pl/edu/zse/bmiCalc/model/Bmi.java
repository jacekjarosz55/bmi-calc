package pl.edu.zse.bmiCalc.model;

import javax.persistence.*;


@Entity(name = "tbmi")
public class Bmi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int wzrost;
    private float waga;

    public Bmi(int id,  int wzrost, float waga) {
        this.id = id;
        this.wzrost = wzrost;
        this.waga = waga;
    }

    public Bmi() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWzrost() {
        return wzrost;
    }

    public void setWzrost(int wzrost) {
        this.wzrost = wzrost;
    }

    public float getWaga() {
        return waga;
    }

    public void setWaga(float waga) {
        this.waga = waga;
    }
}
