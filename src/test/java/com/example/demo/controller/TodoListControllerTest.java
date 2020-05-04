package com.example.demo.controller;

import com.example.demo.controller.model.Status;
import com.example.demo.controller.model.TodoDto;
import com.example.demo.service.TodoListService;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoListController.class)
public class TodoListControllerTest {

    @MockBean
    private TodoListService todoListService;

    @Autowired
    private MockMvc mockMvc;

    private Gson gson = new Gson();

    @Test
    public void createTodoTest() throws Exception {
        TodoDto todoDto = TodoDto.builder()
                .description("yemek ye")
                .title("Yemek")
                .status(Status.DONE)
                .userId("userId:32").build();
        todoListService.createTodo(todoDto);
        verify(todoListService).createTodo(todoDto);
        verify(todoListService,times(1)).createTodo(todoDto);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/todoList")
                .content(gson.toJson(todoDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }


}
