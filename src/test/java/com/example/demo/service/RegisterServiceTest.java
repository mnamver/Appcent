package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.RegisterDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class RegisterServiceTest {

    @MockBean
    private RegisterDao registerDao;

    @Test
    public void createAccountTest(){

        when(registerDao.existsByUsername("aads")).thenThrow(new ValidationException("username is exist"));
        when(registerDao.existsByMail("meh_namver@hotmail.com")).thenThrow(new ValidationException("mail is  exist"));

        Account account = Account.builder()
                .username("manmver")
                .password("asfsfdsf")
                .firstName("mehmet")
                .lastName("namver")
                .mail("sfj@hotmail.com")
                .userId("userid:dafasf")
                .id("sdfsafasf").build();

        registerDao.save(account);
        verify(registerDao, times(1)).save(account);

    }
}
