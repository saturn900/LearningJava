package controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

    private static final String template = "It's yours, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/counter")
    public CurrentState greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new CurrentState(counter.incrementAndGet(),
                String.format(template, name));
    }
}