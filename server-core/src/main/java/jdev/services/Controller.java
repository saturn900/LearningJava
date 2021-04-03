package jdev.services;

import jdev.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Егор on 25.11.2017.
 */
@EnableJpaRepositories("jdev.*")
@EntityScan(basePackageClasses = GPSCoord.class)
@SpringBootApplication
@RestController
public class Controller  {
    Logger logger = LoggerFactory.getLogger(Controller.class);
    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    private List<GPSCoord> all;
    private long previous;

    @Autowired
    FileService FileService;

//    @Autowired
//    DataSendService dataSendService;


    @RequestMapping(value = "DataGps",method = RequestMethod.POST)
    public @ResponseBody
    FileService DataGps (@RequestBody FileService DataGps) { // выглядит нормально, надо только правильно прописать ComponentScan чтобы этот контроллер инициализировался
        // прием выглядит нормально, должен принмиать, можно проверить утилитой curl, но можно и не проверять, а сразу из трекера кидать, или смотрите видео :)
        long current = System.currentTimeMillis();
        logger.info((current - previous) + " lon = " + DataGps.longitude + " lat = " + DataGps.latitude() + "azimuth" + DataGps.azimuth + "speed" + DataGps.azimuth);
//        FileService.writeInFile((current - previous) +"AutoId" + DataGps.getAutoId() + " lon = " + DataGps.getLon() + " lat = " + DataGps.getLat());
        return DataGps;
    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//    @Autowired
//    GPSCoordRepository gpsCoordRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        read();
//    }
//
//    private void delete(GPSCoord gpsCoord) {
//        gpsCoordRepository.delete(gpsCoord);
//    }
//
//    private void update(GPSCoord gpsCoord, String model) {
//        gpsCoord.setModel(model);
//        gpsCoordRepository.save(gpsCoord);
//    }
//
//    private void read() {
//        all = (List<GPSCoord>) gpsCoordRepository.findAll();
//
//        if (all.size() == 0) {
//            log.info("NO RECORDS");
//        } else {
//            all.stream().forEach(rocket -> log.info(rocket.toString()));
//        }
//    }
//
//    private GPSCoord create(String model) {
//        GPSCoord gpsCoord = new GPSCoord();
//        gpsCoord.setModel(model);
//        return gpsCoordRepository.save(gpsCoord);
//    }
}


