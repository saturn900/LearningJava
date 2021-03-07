package jdev.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class DataSendService extends DataPeekService {
    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);

    @Autowired
    private DataPeekService dataPeekService;


    @Scheduled(fixedDelay = 2_000)
    void take() throws InterruptedException {
        System.out.println( "Данные :" );
        log.info("  Широта = " + queue.take() + "  Долгота = " + queue.take());
        log.info("  Азимут = " + queue.take() + "  Скорость = " + queue.take());
    }

}
