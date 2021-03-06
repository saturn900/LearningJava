package jdev.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


@Service
public class DataSendService extends DataPeekService {
    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);

    private BlockingDeque<String> queue = new LinkedBlockingDeque<>(100);
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
        int i = putCount++;
        log.info("take ting!!ai");
        Coordinats coordinats = new Coordinats();
        System.out.println( "Данные :" );
        log.info("Какие то цифры: " + queue.take());
    }

}
