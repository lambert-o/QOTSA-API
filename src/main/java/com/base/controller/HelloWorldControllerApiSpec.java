package com.base.controller;

import com.base.domain.request.HelloRequest;
import com.base.domain.response.HelloResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.base.controller.HelloWorldController.HELLO_PATH;

@RequestMapping(value = HELLO_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public interface HelloWorldControllerApiSpec {

    @Operation(
            summary = "Hello request submissions",
            description = "Returns a basic response saying hello",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Hello Response", content = {
                            @Content(schema = @Schema(implementation = HelloResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad request", content = {
                            @Content(examples = @ExampleObject(value = "{\n"
                                    + "    \"status\": 400,\n"
                                    + "    \"message\": \"Missing request parameter 'name'\"\n"
                                    + "}"))
                    }),
                    @ApiResponse(responseCode = "500",
                            description = "Internal Server Error / No message available", content = {
                            @Content(examples = @ExampleObject(value = "{\n"
                                    + "  \"status\": 500,\n"
                                    + "  \"message\": \"Cannot process request\"\n"
                                    + "}"))
                    })
            }
    )
    @GetMapping("/hello")
    ResponseEntity<HelloResponse> hello(
            @Parameter(name = "HelloRequest", schema =
            @Schema(implementation = HelloRequest.class))
            @ModelAttribute("helloRequest") @Valid HelloRequest helloRequest);
}
