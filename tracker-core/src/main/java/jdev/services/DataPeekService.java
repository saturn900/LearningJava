package jdev.services;

//import org.springframework.beans.factory.annotation.Autowired;
import jdev.dto.PointDTO;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class DataPeekService  {

//    private static final Logger log = LoggerFactory.getLogger( DataPeekService.class );

    public BlockingDeque<PointDTO> queue = new LinkedBlockingDeque<>( 100 );

//    @Scheduled(fixedDelay = 1_000)
//    void put(PointDTO gps) throws InterruptedException {
//        Coordinats coordinats = new Coordinats();
//        queue.put( coordinats.getLatitude());
//        queue.put( coordinats.getLongitude());
//        queue.put( coordinats.getAzimuth());
//        queue.put( coordinats.getSpeed());
//    }


    public BlockingDeque<PointDTO> getQueue() {
        return queue;
    }

    PointDTO take() throws InterruptedException{
        return queue.take();
    }

    void put(PointDTO newpoint) throws InterruptedException {
        queue.put(newpoint);
    }
}
