package com.base.controller;

import com.base.domain.request.HelloRequest;
import com.base.domain.response.HelloResponse;
import com.base.service.HelloService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class HelloWorldController implements HelloWorldControllerApiSpec {

    public static final String HELLO_PATH = "/v1/my-controller";

    private final HelloService helloService;


    @Override
    public ResponseEntity<HelloResponse> hello(@ModelAttribute("helloRequest") @Valid HelloRequest helloRequest) {
        log.info("Calling hello service");
        String helloString = helloService.hello(helloRequest);
        HelloResponse helloResponse = new HelloResponse(helloString);
        return ResponseEntity.ok(helloResponse);
    }
}
