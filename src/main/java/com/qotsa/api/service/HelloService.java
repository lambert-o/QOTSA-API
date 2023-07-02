package com.qotsa.api.service;

import com.qotsa.api.domain.request.HelloRequest;
import com.qotsa.api.dto.HelloDto;
import com.qotsa.api.repository.MyDatabaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final MyDatabaseRepository myDatabaseRepository;
    public String hello(HelloRequest helloRequest) {
        HelloDto helloDto = new HelloDto();
        helloDto.setName(helloRequest.getName());
        myDatabaseRepository.save(helloDto);
        return "Hello, " + helloRequest.getName();
    }
}
