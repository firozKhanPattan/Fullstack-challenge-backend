package com.dev.flightfinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

		@Bean
		public Docket flightfinderApi() {
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("com.dev.flightfinder"))
	          .paths(PathSelectors.any())                          
	          .build()
	          .apiInfo(getApiInfo());
	                                                  
	    }
		private ApiInfo getApiInfo() {
	        return new ApiInfoBuilder()
	                .title("Fullstack development Challenge- FlightFinder Project")
	                .description("Provides the flight details of the to and fro travel")
	                .version("1.0.0")
	                .license("Apache License Version 2.0")
	                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
	                .contact(new Contact("Firoz Khan Pattan","no url","firozkhanpattan786@gmail.com"))
	                .build();
	    }
		
	}

