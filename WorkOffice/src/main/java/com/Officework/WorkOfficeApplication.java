package com.Officework;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EntityScan(basePackages = {"com/Officework/Entity"})
public class WorkOfficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkOfficeApplication.class, args);
	}
//	@Bean
//	public ModelMapper modelMapper()
//	{
//		return new ModelMapper();
//	}
}
