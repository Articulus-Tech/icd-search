package io.articulus.hit.icdsearch;

import org.h2.tools.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IcdSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcdSearchApplication.class, args);
    }

    @Bean
    public CommandLineRunner exposeH2Port() {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
                Server server = Server.createTcpServer().start();
                System.out.println("Running on H2 port: " + server.getPort() + " " + server.getURL());
            }
        };
    }
}
