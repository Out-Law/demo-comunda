package com.example.demo_camunda.components;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

@Component
public class RequestPaymentConfirmation {

    @JobWorker(type = "request-for-payment-confirmation")
    public Map<String, Integer> requestPaymentConfirmation(
            @Variable(name = "id") Integer id,
            @Variable(name = "startDate") LocalDate startDate,
            @Variable(name = "endDate") LocalDate endDate
    ) {
        Integer ratio = 1500;
        return Map.of("payment", ratio);
    }
}
