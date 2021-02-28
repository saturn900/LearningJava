package jdev.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


@Service
public class DataSendService {
    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);

    private BlockingDeque<String> queue = new LinkedBlockingDeque<>(100);
    private int putCount;
    private long previous;

    // public void callFromInit() {
    //   System.out.println("шляпа");
    //}

    @Scheduled(fixedDelay = 1_000)
    void take() throws InterruptedException {
        int i = putCount++;
        log.info("take trying!!!");
        long current = System.currentTimeMillis();
        //log.info((current - previous) + " ScheduledQueueService.take " + queue.poll(500, TimeUnit.MILLISECONDS));
        System.out.println((current - previous) + " ScheduledQueueService.take " + queue.take());
        previous = current;

    }

}
