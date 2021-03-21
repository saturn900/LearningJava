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
public class DataSendService extends DataPeekService {
    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private DataPeekService dataPeekService;


    @Scheduled(cron = "${cron.prop30sec}")
    public void sendGPStoServer() throws InterruptedException, JsonProcessingException {
        int i=0;
        for (PointDTO point:dataPeekService.getQueue()) {
            restTemplate.postForObject("http://localhost:8080/points", point, PointDTO.class);
            i++;
        }
    }

}
