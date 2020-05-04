package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.RegisterService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RegisterController.class)
public class RegisteerControllerTest {

    @MockBean
    private RegisterService registerService;

    @Autowired
    private MockMvc mockMvc;

    private Gson gson = new Gson();

    @Test
    public void getAllTodoListTest() throws Exception {
        List<Account> accountList = new ArrayList<>();

        Account account = Account.builder().id("123").userId("userid:123").mail("mehmet_namver@gmail.com")
                .lastName("namver").firstName("mehmet").password("sdfsaf").username("mnamver").build();

        Account account2 = Account.builder().id("2312").userId("userid:34234").mail("şef_namver@gmail.com")
                .lastName("namver").firstName("şef").password("adsad").username("snamver").build();

        accountList.add(account);
        accountList.add(account2);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/register")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        given(registerService.getAllToDoList()).willReturn(accountList);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(gson.toJson(accountList)));
    }

}
