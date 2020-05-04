package com.example.demo.controller.model;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class TodoDto {

    @NotEmpty(message = "username may not be empty")
    @NotNull(message = "username may not be null")
    private String userId;

    private String title;
    private String description;
    private Status status;
}
