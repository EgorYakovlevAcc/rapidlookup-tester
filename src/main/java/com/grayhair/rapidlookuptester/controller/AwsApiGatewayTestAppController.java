package com.grayhair.rapidlookuptester.controller;

import com.grayhair.rapidlookuptester.service.AwsApiGatewayRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsApiGatewayTestAppController {
    @Autowired
    private AwsApiGatewayRequestService requestService;

    @GetMapping("/execute/")
    public String executeTestRequests(@RequestParam("amount_of_requests") Integer amountOfRequests) {
        requestService.sendTestRequests(amountOfRequests);
        return "finish";
    }
}
