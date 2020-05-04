package com.example.demo.entity;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    private String id;

    @Field
    private String userId;

    @Field
    @NotNull
    private String username;

    @Field
    @NotNull
    private String password;

    @Field
    @NotNull
    private String firstName;

    @Field
    @NotNull
    private String lastName;

    @Field
    @NotNull
    private String mail;


}
