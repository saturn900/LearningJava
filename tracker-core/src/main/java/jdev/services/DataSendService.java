package jdev.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service

public class DataSendService {

    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);

    @Autowired
    private DataPeekService dataPeekService;

    RestTemplate restTemplate = new RestTemplate();


    @Scheduled(fixedDelay = 2_000)
    void take() throws InterruptedException {
        System.out.println( "Данные :" );
        log.info("  Координаты = " + dataPeekService.getCoor());
    }

    @Scheduled(cron = "${cron.prop30sec}")
    public void sendCoordinats() throws InterruptedException, JsonProcessingException {
        int i=0;
        for (Coordinats point:dataPeekService.getQueue()) {
            restTemplate.postForObject("http://localhost:8080/points", point, PointDTO.class);
        }
    }

}
