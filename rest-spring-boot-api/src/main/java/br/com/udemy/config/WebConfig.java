package br.com.udemy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
	}

	
	
	
}
