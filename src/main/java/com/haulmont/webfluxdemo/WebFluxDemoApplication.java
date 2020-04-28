package com.haulmont.webfluxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.haulmont.webfluxdemo" })
public class WebFluxDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFluxDemoApplication.class, args);
	}

}

