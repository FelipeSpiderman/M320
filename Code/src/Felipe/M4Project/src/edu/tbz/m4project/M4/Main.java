package edu.tbz.m4project.M4;

import edu.tbz.m4project.M4ProjectApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(M4ProjectApplication.class, args);
        try {
            ConsoleApp app = ctx.getBean(ConsoleApp.class);
            app.run();
        } finally {
            ctx.close();
        }
    }
}
