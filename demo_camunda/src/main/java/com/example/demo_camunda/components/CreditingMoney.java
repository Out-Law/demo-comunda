package com.example.demo_camunda.components;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CreditingMoney {

    @JobWorker(type = "crediting-money")
    public Map<String, Integer> requestConfirmationDate(
            @Variable(name = "payment") Integer payment
    ) {
        return Map.of("res", 500-payment);
    }
}
