package jdev.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class DataSendService extends DataPeekService {
    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);

 //   private BlockingDeque<String> queue = new LinkedBlockingDeque<>(100);
    private int putCount;
    private long previous;

    @Autowired
    private DataPeekService dataPeekService;

//    @PostConstruct
 //   private void ask() {
 //       dataPeekService.ask(); }

    // public void callFromInit() {
    //   System.out.println("шляпа");
    //}

    @Scheduled(fixedDelay = 1_000)
    void take() throws InterruptedException {
       int speed = 0;
        log.info("take tingai !!");
        //Coordinats coordinats = dataPeekService.getCoordinats();
        System.out.println( "Данные :" );
        System.out.println(" i = " + queue.take());
        System.out.println(" a = " + queue.take());
    }

}
