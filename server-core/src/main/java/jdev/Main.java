package jdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Егор on 25.11.2017.
 */
@SpringBootApplication
@ComponentScan({"jdev.services"}) //  Начальная точка
public class Main{
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
