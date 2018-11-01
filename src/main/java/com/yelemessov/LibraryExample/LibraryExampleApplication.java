package com.yelemessov.LibraryExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class LibraryExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryExampleApplication.class, args);
	}
}
