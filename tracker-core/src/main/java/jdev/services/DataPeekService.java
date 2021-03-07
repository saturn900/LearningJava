package jdev.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class DataPeekService  {

    private static final Logger log = LoggerFactory.getLogger( DataPeekService.class );

    public BlockingDeque<Object> queue = new LinkedBlockingDeque<Object>( 100 );

    @Scheduled(fixedDelay = 1_000)
    void put() throws InterruptedException {
        Coordinats coordinats = new Coordinats();
        queue.put( coordinats.getLatitude());
        queue.put( coordinats.getLongitude());
        queue.put( coordinats.getAzimuth());
        queue.put( coordinats.getSpeed());

     }

}