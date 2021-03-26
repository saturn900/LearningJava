package jdev.services;

import org.springframework.stereotype.Service;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Егор on 25.11.2017.
 */

@Service
public class FileService {


    private File file = new File("server-core//src//main//resources//points.txt");

    public int latitude;
    public int longitude;
    public int azimuth;
    public int speed;


    public FileService(){ // создан конструктор по умолчанию, так как спринг не может найти аргументы для конструктора с параметрами
    }

    public FileService(int latitude,int longitude,int azimuth, int speed){
        this.latitude = latitude;
        this.longitude = longitude;
        this.azimuth = azimuth;
        this.speed = speed;

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

    public void writeInFile(String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            bw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int latitude() {
        return this.latitude;
    }
}

