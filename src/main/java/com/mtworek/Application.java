package com.mtworek;

/**
 * Created by mikolaj on 28.11.17.
 */
import com.mtworek.dao.ApplicationRepository;
import com.mtworek.model.Drivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import java.util.stream.Stream;

import static java.lang.System.exit;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    ApplicationRepository applicationRepository;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Transactional(readOnly = true)
    @Override
    public void run(String... args) throws Exception {

        System.out.println("DATASOURCE = " + dataSource);

        System.out.println("\n1.findAll()...");
        for (Drivers drivers : applicationRepository.findAll()) {
            System.out.println(drivers);
        }

        System.out.println("\n2.findByAge(int age)...");
        for (Drivers drivers : applicationRepository.findByAge(20)) {
            System.out.println(drivers);
        }

        System.out.println("\n3.findByFirstName(String firstName)...");
        for (Drivers drivers : applicationRepository.findByFirstName("Test1")) {
            System.out.println(drivers);
        }

        // For Stream, need @Transactional
        System.out.println("\n4.findByLastNameReturnStream(@Param(\"lastName\") String lastName)...");
        try (Stream<Drivers> stream = applicationRepository.findByLastNameReturnStream("Testowy2")) {
            stream.forEach(x -> System.out.println(x));
        }

        System.out.println("Done!");

        exit(0);
    }

}
