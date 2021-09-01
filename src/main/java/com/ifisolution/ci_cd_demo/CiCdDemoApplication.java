package com.ifisolution.ci_cd_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CiCdDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiCdDemoApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "<h1>Hello from devops lab<h1> " +
				"<h2>Hello from devops engineer<h2>" +
				"<h3>pushing from intellj trigger some build";
	}

}
