package com.example.springbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableBatchProcessing
public class SpringBootDevSpringbatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDevSpringbatchApplication.class, args);
	}

}
