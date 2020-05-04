package com.example.demo.service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.example.demo.controller.model.TodoDto;
import com.example.demo.entity.Todo;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.RegisterDao;
import com.example.demo.repository.TodoListDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoListService {

    private final TodoListDao todoListDao;
    private final RegisterDao registerDao;
    private static final String TODO_ID = "TodoId:";
    private final static String TODO_IS_NOT_EXIST = "todo bulunamadı";
    private final static String ACCOUNT_ID_NOT_EXIST = "Bu accountId sistemde tanımlı değil";
    private final static String ID_NOT_EXIST = "id bulunamadı";

    public TodoListService(TodoListDao todoListDao, RegisterDao registerDao) {
        this.todoListDao = todoListDao;
        this.registerDao = registerDao;
    }

    public List<Todo> getTodoListByUserId(String userId) {
        if (registerDao.existsByAccountId(userId) == 0) {
            throw new ValidationException(ACCOUNT_ID_NOT_EXIST);
        }

        return todoListDao.findByUserId(userId);
    }

    public Optional<Todo> getTodoListById(String id) {
        if (todoListDao.existsByTodoId(id) == 0) {
            throw new ValidationException(TODO_IS_NOT_EXIST);
        }

        return todoListDao.findById(id);
    }

    public void deleteById(String id) {
        if (todoListDao.existsByTodoId(id) == 0) {
            throw new ValidationException(ID_NOT_EXIST);
        }

        todoListDao.deleteById(id);
    }

    public void createTodo(TodoDto todoDto) {
        Todo todo = Todo.builder()
                .id(TODO_ID + UUID.randomUUID().toString())
                .todoId(UUID.randomUUID().toString())
                .userId(todoDto.getUserId())
                .title(todoDto.getTitle())
                .description(todoDto.getDescription())
                .status(todoDto.getStatus())
                .build();
        todoListDao.save(todo);
    }

}
