package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class TestController {

    /*@Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private WebClient.Builder webClientBuilder;
    @GetMapping("/test")
    public String test() {
        return webClientBuilder.build().get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
        //return restTemplate.getForObject("http://service1/test", String.class);
    }
}
