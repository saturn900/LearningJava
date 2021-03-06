package jdev.services;

public class Coordinats extends DataPeekService {
    public int latitude ;
    public int longitude;
    public int azimuth;
    public int speed;

    public int сoordinats(){
        this.latitude = 10;
        this.longitude = 20;
        this.azimuth = 30;
        this.speed = 40;
        return сoordinats();
    }

}
