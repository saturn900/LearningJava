package jdev.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class DataSendServiceTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    DataSendService mockedController;

    @Test
    public void take() throws InterruptedException {
        String url = "http://localhost:8080/DataGps";
        restTemplate = new RestTemplate();
       Coordinats coordinats  = new Coordinats();
        coordinats.setSpeed(10);
        coordinats.setAzim(20);
        coordinats.setLatitude(30);
        coordinats.setLongitude(40);
        String DataGps;
        DataGps = restTemplate.postForObject(url, coordinats, String.class);
        String expectedResult = "{\"latitude\":30,\"longitude\":40,\"azimuth\":20,\"speed\":10}";
        Assert.assertEquals(expectedResult, DataGps);

    }
}