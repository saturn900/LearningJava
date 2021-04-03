package jdev.jpa;

import jdev.dao.GPSCoord;
import jdev.dao.repo.GPSCoordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@SpringBootApplication
@EnableJpaRepositories("jdev.dao")
@EntityScan(basePackageClasses = jdev.dao.GPSCoord.class)
public class JpaApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);
    private List<GPSCoord> all;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    GPSCoordRepository gpsCoordRepository;

    @Override
    public void run(String... args) throws Exception {
        read();

        GPSCoord soyuz = create( "Soyuz");
        GPSCoord falcon = create( "Falcon");
        GPSCoord angara = create("Angara");
        log.info("=========== after create");
        read();

        update(soyuz, "Soyuz 2");
        update(falcon, "Falcon 9");
        update(angara, "Angara A5");

        log.info("=========== after update");
        read();

        delete(soyuz);
        log.info("=========== after delete 1");
        read();

        delete(falcon);
        log.info("=========== after delete 2");
        read();

        delete(angara);
        log.info("=========== after delete 3");
        read();

        delete(angara);
        log.info("=========== after delete 4");
        read();
    }

    private void delete(GPSCoord gpsCoord) {
        gpsCoordRepository.delete(gpsCoord);
    }

    private void update(GPSCoord gpsCoord, String model) {
        gpsCoord.setModel(model);
        gpsCoordRepository.save(gpsCoord);
    }

    private void read() {
        all = (List<GPSCoord>) gpsCoordRepository.findAll();

        if (all.size() == 0) {
            log.info("NO RECORDS");
        } else {
            all.stream().forEach(rocket -> log.info(rocket.toString()));
        }
    }

    private GPSCoord create(String model) {
        GPSCoord gpsCoord = new GPSCoord();
        gpsCoord.setModel(model);
        return gpsCoordRepository.save(gpsCoord);
    }
}
