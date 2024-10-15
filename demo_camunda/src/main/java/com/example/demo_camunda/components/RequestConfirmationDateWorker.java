package com.example.demo_camunda.components;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class RequestConfirmationDateWorker {

    Map<Integer, String> userMap = new HashMap<>();
    private final static Logger LOG = LoggerFactory.getLogger(RequestConfirmationDateWorker.class);

    @JobWorker(type = "request-for-confirmation-of-the-date")
    public Map<String, Integer> requestConfirmationDate(
            @Variable(name = "id") Integer id,
            @Variable(name = "startDate") LocalDate startDate,
            @Variable(name = "endDate") LocalDate endDate
    ) {



        LOG.info("id: {}", id);
        LOG.info("startDate: {}", startDate);
        userMap.put(id, "Name");
        return Map.of("bd", 1);
    }
}
