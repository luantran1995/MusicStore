package com.luantran.musicstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MuicNashTechApplication  extends SpringBootServletInitializer  {
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(MuicNashTechApplication.class);
	    }
	public static void main(String[] args) {
		SpringApplication.run(MuicNashTechApplication.class, args);
	}
}
