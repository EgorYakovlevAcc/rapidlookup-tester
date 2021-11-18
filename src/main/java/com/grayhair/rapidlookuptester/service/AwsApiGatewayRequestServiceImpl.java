package com.grayhair.rapidlookuptester.service;

import com.grayhair.rapidlookuptester.pojo.Pagination;
import com.grayhair.rapidlookuptester.pojo.Query;
import com.grayhair.rapidlookuptester.pojo.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class AwsApiGatewayRequestServiceImpl implements AwsApiGatewayRequestService {
    @Autowired
    private WebClient webClient;

    private List<Mono<String>> getRequestsList(int amountOfRequests) {
        List<Mono<String>> requestsList = new ArrayList<>();
        Request request = new Request();
        Query query = new Query();
        query.setCity("New York");
        query.setFirstMailDate("2021-04-03 04:00:00");
        query.setName("x");
        request.setQuery(query);
        Pagination pagination = new Pagination();
        pagination.setFrom(0);
        pagination.setSize(12);
        request.setPagination(pagination);
        for (int i = 0; i < amountOfRequests; i++) {
            requestsList.add(this.webClient
                    .post()
                    .body(Mono.just(request), Request.class)
                    .retrieve()
                    .bodyToMono(String.class)
            );
        }
        return requestsList;
    }

    @Override
    public void sendTestRequests(int amountOfRequests) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<Mono<String>> requestsList = getRequestsList(amountOfRequests);
        for (Mono<String> request : requestsList) {
            try {
                request.subscribe(System.out::println);
            }
            catch (HttpClientErrorException httpClient);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
