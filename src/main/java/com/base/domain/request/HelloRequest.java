package com.base.domain.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HelloRequest {

    @NotBlank(message = "Name is required")
    public String name;
}
