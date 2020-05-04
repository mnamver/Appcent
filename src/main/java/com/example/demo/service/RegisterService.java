package com.example.demo.service;

import com.example.demo.controller.model.RegistrationDto;
import com.example.demo.entity.Account;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.RegisterDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RegisterService {


    private static final String USER_ID = "UserId:";
    private static final String USERNAME_ALREADY_EXIST = "username sistemde mevcut.";
    private static final String MAIL_ALREADY_EXIST = "Mail sistemde mevcut.";

    private final RegisterDao registerDao;

    public List<Account> getAllToDoList() {
        return registerDao.findAll();
    }

    public void createAccount(RegistrationDto registrationDto) {
        if (registerDao.existsByUsername(registrationDto.getUsername()) > 0) {
            throw new ValidationException(USERNAME_ALREADY_EXIST);
        }
        if (registerDao.existsByMail(registrationDto.getMail()) > 0) {
            throw new ValidationException(MAIL_ALREADY_EXIST);
        }

        Account account = Account.builder()
                .id(USER_ID + UUID.randomUUID().toString())
                .userId(UUID.randomUUID().toString())
                .username(registrationDto.getUsername())
                .password(registrationDto.getPassword())
                .firstName(registrationDto.getFirstName())
                .lastName(registrationDto.getLastName())
                .mail(registrationDto.getMail())
                .build();

        registerDao.save(account);
    }
}
