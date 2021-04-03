package jdev;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Егор on 25.11.2017.
 */


@ComponentScan({"jdev.services","jdev.repo"})
public class Main{
    public static void main (String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

}
