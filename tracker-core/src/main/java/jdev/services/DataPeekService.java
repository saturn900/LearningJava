package jdev.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class DataPeekService {

    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);

    private BlockingDeque<String> queue =  new LinkedBlockingDeque<>(100);
    private int putCount;
    private long previous;
    private String tryz;

    @Autowired
    private DataSendService dataSendService;

    //@PostConstruct
    //private void init() throws InterruptedException {dataSendService.take(); }



    @Scheduled (fixedDelay = 1_000)
    void put() throws InterruptedException {
        int i = putCount++;
        log.info("ScheduledQueueService.put " + i);
        queue.put("new string => " + i);
        //System.out.println(nameFac);
        //init();
    }
    public String ask(){
        tryz = ("шляпа");
        return tryz;
    }
}
