package com.sns.snsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SnsjavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnsjavaApplication.class, args);
	}

}
