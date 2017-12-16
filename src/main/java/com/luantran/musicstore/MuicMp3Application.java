package com.luantran.musicstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MuicMp3Application  extends SpringBootServletInitializer  {
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(MuicMp3Application.class);
	    }
	public static void main(String[] args) {
		SpringApplication.run(MuicMp3Application.class, args);
	}
}
