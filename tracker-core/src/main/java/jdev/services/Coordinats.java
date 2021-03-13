package jdev.services;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Coordinats {
    public int latitude = 10;
    public int longitude = 20;
    public int azimuth = 30;
    public int speed = 40;

    @Autowired
    DataPeekService dataPeekService;

    @PostConstruct
    @Scheduled(cron = "${cron.prop}")
    private void init() throws Exception{
        dataPeekService.put(getGPS());
    }

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

    public void setAzimuth(int azimuth) {
        this.azimuth = azimuth;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
