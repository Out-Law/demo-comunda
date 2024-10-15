package com.example.demo_camunda;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
@Deployment(resources = "classpath:Process_RequestAnualLeave.bpmn")
public class DemoCamundaApplication implements CommandLineRunner {

	private final ZeebeClient zeebeClient;

	public DemoCamundaApplication(ZeebeClient zeebeClient) {
		this.zeebeClient = zeebeClient;
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoCamundaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var bpmnProcessId = "Process_RequestAnualLeave"; // замените на нужный вам идентификатор
		var event = zeebeClient.newCreateInstanceCommand()
				.bpmnProcessId(bpmnProcessId)
				.latestVersion()
				.variables(Map.of("id", 123))
				.send()
				.join();
	}
}
