package com.Spring.journey.Week1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@SpringBootApplication
public class Week1Application implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Week1Application.class, args);
	}
	@Autowired
	private BakeryService bs;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(bs.bakeCake());
	}
}
