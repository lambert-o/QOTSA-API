package com.base.service;

import com.base.domain.request.HelloRequest;
import com.base.repository.MyDatabaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class HelloServiceTest {

    @Mock
    MyDatabaseRepository myDatabaseRepository;

    @InjectMocks
    HelloService helloService;

    @Test
    void shouldReturnValidResponseWhenRequestValid() {
        // given
        HelloRequest request = new HelloRequest("Owen Lambert");

        // when
        var response = helloService.hello(request);

        // then
        assertEquals("Hello, Owen Lambert", response);
    }
}
