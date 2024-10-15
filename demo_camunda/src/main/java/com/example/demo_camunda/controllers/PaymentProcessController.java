package com.example.demo_camunda.controllers;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Deployment(resources = "classpath:Process_RequestAnualLeave.bpmn")
public class PaymentProcessController {

    private final ZeebeClient zeebeClient;

    public PaymentProcessController(ZeebeClient zeebeClient) {
        this.zeebeClient = zeebeClient;
    }

    @PostMapping("/start-process")
    public String startPaymentProcess(@RequestBody Integer id) {
        var bpmnProcessId = "Process_RequestAnualLeave"; // замените на нужный вам идентификатор
        var event = zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(bpmnProcessId)
                .latestVersion()
                .variables(Map.of("id", id))
                .send()
                .join();

        return String.format("Процесс запущен с ключом: %d", event.getProcessInstanceKey());
    }
}
