package jdev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jdev on 26.03.2017.
 */
public class Main {
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(jdev.InjectionContext.class);
    }
}
