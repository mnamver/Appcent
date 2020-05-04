package com.example.demo.service;

import com.example.demo.exception.ValidationException;
import com.example.demo.repository.TodoListDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class TodoListServiceTest {


    @MockBean
    private TodoListDao todoListDao;

    @Test
    public void deletebyIdTest(){
        when(todoListDao.existsByTodoId("asdsad") == 0).thenThrow(new ValidationException("id is not exist"));
        todoListDao.deleteById("sdf");
        verify(todoListDao,times(1)).deleteById("sdf");

    }
}
