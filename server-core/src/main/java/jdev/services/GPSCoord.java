package jdev.services;


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
    String latitude;

    @Column(name = "longitude")
    String longitude;

    @Column(name = "azimuth")
    String azimuth;

    @Column(name = "speed")
    String speed;


    public String toString() {
        return "GPSCoord{ id=" + id + ", model1=" + latitude + ", model2=" + longitude
                + ", model3=" + azimuth + ", model4=" + speed + " }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getModel3() {
        return azimuth;
    }

    public void setModel3(String model3) {
        this.azimuth = azimuth;
    }

    public String getModel44() {
        return azimuth;
    }

    public void setModel4(String model4) {
        this.azimuth = azimuth;
    }



}
