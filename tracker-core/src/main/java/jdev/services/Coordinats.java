package jdev.services;

import jdev.dto.PointDTO;

public class Coordinats {
    public int latitude = 10;
    public int longitude = 20;
    public int azimuth = 30;
    public int speed = 40;


    public PointDTO getGPS() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(this.latitude);
        point.setLon(this.longitude);
        point.setAzim(this.azimuth);
        point.setSpeed(this.speed);
        return point;
    }


    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getAzimuth() {
        return azimuth;
    }

    public void setAzim(int azimuth) {
        this.azimuth = azimuth;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.join("; ", String.valueOf(latitude), String.valueOf(longitude), String.valueOf(azimuth), String.valueOf(speed));
    }
}
