package com.grayhair.rapidlookuptester.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerServiceImpl {
    @Autowired
    private AwsApiGatewayRequestService awsApiGatewayRequestService;

    @Scheduled(fixedRate = 60000)
    public void timer() {
        System.out.println("Scheduled task execution [START]");
        awsApiGatewayRequestService.sendTestRequests(4000);
    }
}
