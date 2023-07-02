package com.base.service;

import com.base.domain.request.HelloRequest;
import com.base.dto.HelloDto;
import com.base.repository.MyDatabaseRepository;
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
