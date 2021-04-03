package jdev.services;

import jdev.repo.GPSCoordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Егор on 25.11.2017.
 */

@SpringBootApplication
@EnableJpaRepositories("jdev.repo")
@EntityScan(basePackageClasses = jdev.services.GPSCoord.class)
@RestController
public class Controller {
    Logger logger = LoggerFactory.getLogger(Controller.class);
    private long previous;

    @Autowired
    FileService FileService;


    @Autowired
    GPSCoordRepository gpsCoordRepository;


    @RequestMapping(value = "DataGps",method = RequestMethod.POST)
    public @ResponseBody
    FileService DataGps (@RequestBody FileService DataGps) { // выглядит нормально, надо только правильно прописать ComponentScan чтобы этот контроллер инициализировался
        // прием выглядит нормально, должен принмиать, можно проверить утилитой curl, но можно и не проверять, а сразу из трекера кидать, или смотрите видео :)
        long current = System.currentTimeMillis();
        logger.info((current - previous) + " lon = " + DataGps.longitude + " lat = " + DataGps.latitude() + "azimuth" + DataGps.azimuth + "speed" + DataGps.azimuth);
//        FileService.writeInFile((current - previous) +"AutoId" + DataGps.getAutoId() + " lon = " + DataGps.getLon() + " lat = " + DataGps.getLat());
        return DataGps;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }



    //можно добавить метод с аннотацией PostConstruct и в нем вывод в лог, чтобы проверить что данный контроллер инициализируется спрингом
}
