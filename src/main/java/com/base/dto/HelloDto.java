package com.base.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "my_table", schema = "my_schema")
public class HelloDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "The name received via the hello endpoint", example = "Owen Lambert")
    public String name;
}
