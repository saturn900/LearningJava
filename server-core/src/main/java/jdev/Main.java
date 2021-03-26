package jdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Егор on 25.11.2017.
 */
@SpringBootApplication
@ComponentScan({"jdev.services"}) // неверные имена пакетов в которых уже спринг будет искать бины!!! были, теперь норм, запускабельно
public class Main{
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
