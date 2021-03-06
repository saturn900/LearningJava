package jdev.services;

//import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class DataPeekService {

    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);

    private BlockingDeque<Integer> queue =  new LinkedBlockingDeque<Integer>(100);
    private int putCount;
    private long previous;
    public int latitude = 10;
    public int longitude = 10;
    public int azimuth = 20;
    public int speed = 30;



//    @Autowired
//    private DataSendService dataSendService;

    //@PostConstruct
    //private void init() {dataSendService.callFromInit();
    //}



    @Scheduled (fixedDelay = 1_000)
    void put() throws InterruptedException {
        int i = putCount++;
        log.info( String.valueOf("Широта -" + latitude) );
        log.info( String.valueOf("Долгота -" + longitude) );
        log.info( String.valueOf("Азимут -" + azimuth) );
        log.info( String.valueOf("Скорость -" + speed) );
//        queue.put(coord); coord - класс с полями  latitude longitude azimuth speed
        queue.put(latitude);
        queue.put(longitude);
        queue.put(azimuth);
        queue.put(speed);

    }

    public Coord getCoord() {
        return queue.take();
    }
}
