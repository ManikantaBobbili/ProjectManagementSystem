package com.ProjectM.ProjectManagementSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;


@SpringBootApplication
public class ProjectManagementSystemApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProjectManagementSystemApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
		app.run(args);

	}
}
