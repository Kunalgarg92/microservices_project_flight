package com.flight_service;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.flight_service.repository.FlightInventoryRepository;

import jakarta.annotation.PostConstruct;
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class FlightServiceMicroAssignmentApplication {
	
	@Autowired
    private FlightInventoryRepository repository;

	 @Autowired
	    private MongoTemplate mongoTemplate;  
	 
	public static void main(String[] args) {
		SpringApplication.run(FlightServiceMicroAssignmentApplication.class, args);
	}
	
	   @PostConstruct
	    public void checkDb() {
	        System.out.println("Connected Database: " + mongoTemplate.getDb().getName());
	        System.out.println("Collections: " + mongoTemplate.getCollectionNames());
	    }


}
