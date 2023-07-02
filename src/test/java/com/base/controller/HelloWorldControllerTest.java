package com.base.controller;

import com.base.domain.request.HelloRequest;
import com.base.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class HelloWorldControllerTest {

    @Mock
    HelloService helloService;

    @InjectMocks
    HelloWorldController helloWorldController;

    @Test
    void shouldReturnValidResponseWhenRequestValid() {
        // given
        HelloRequest request = new HelloRequest("Owen Lambert");
        given(helloService.hello(request)).willReturn("Hello, Owen Lambert");

        // when
        var response = helloWorldController.hello(request);

        // then
        assertEquals("Hello, Owen Lambert", response.getBody().getResponse());
    }
}
