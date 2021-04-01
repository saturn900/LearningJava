package jdev.dao;


import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="GPSCoord")
public class GPSCoord {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "latitude")
    String model1;

    @Column(name = "longitude")
    String model2;

    @Column(name = "azimuth")
    String model3;

    @Column(name = "speed")
    String model4;


    public String toString() {
        return "GPSCoord{ id=" + id + ", model1=" + model1 + ", model2=" + model2
                + ", model3=" + model3 + ", model4=" + model4 + " }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model1;
    }

    public void setModel(String model1) {
        this.model1 = model1;
    }

    public String getModel2() {
        return model2;
    }

    public void setModel2(String model2) {
        this.model2 = model2;
    }

    public String getModel3() {
        return model3;
    }

    public void setModel3(String model3) {
        this.model3 = model3;
    }

    public String getModel44() {
        return model4;
    }

    public void setModel4(String model4) {
        this.model4 = model4;
    }



}
