package jdev.services;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import org.apache.commons.io.IOUtils;


@Service
public class DataSendService{
    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);

    Object DataGps;

    @Autowired
    private DataPeekService dataPeekService;

    @Autowired
    public Coordinats coordinats;



//    @Autowired
//    public RestTemplate restTemplate;

    RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedDelay = 2_000)
    void take() throws InterruptedException {
        System.out.println( "Данные :" );
//        log.info("  Координаты = " + dataPeekService.getCoor());
        DataGps = dataPeekService.getCoor();
        System.out.println( DataGps );

        // вот здесь создать RestTemplate и выполнить отправку
        restTemplate.postForObject("http://localhost:8080/points", DataGps, PointDTO.class);
    }



}
