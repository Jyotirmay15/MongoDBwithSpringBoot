package com.example.MongoDBDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.repository")
@ComponentScan("com.example.*")
public class MongoDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbDemoApplication.class, args);
	}
}
