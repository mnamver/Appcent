package com.example.demo.entity;

import com.couchbase.client.java.repository.annotation.Field;
import com.example.demo.controller.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {

    @Id
    private String id;

    @Field
    private String todoId;

    @Field
    private String userId;

    @Field
    private String title;

    @Field
    private String description;

    @Field
    private Status status;

}
