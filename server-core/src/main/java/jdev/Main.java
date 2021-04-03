package jdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Created by Егор on 25.11.2017.
 */

@SpringBootApplication
@EnableJpaRepositories("jdev.dao")
@EntityScan(basePackageClasses = jdev.dao.GPSCoord.class)
@ComponentScan({"jdev.services","jdev.dao"})
public class Main{
    public static void main (String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
