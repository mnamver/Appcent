package com.example.demo.controller;


import com.example.demo.controller.model.TodoDto;
import com.example.demo.entity.Todo;
import com.example.demo.service.TodoListService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/todoList")
@AllArgsConstructor
@RestController
public class TodoListController {

    private final TodoListService todoListService;

    @PostMapping()
    public ResponseEntity createTodo(@RequestBody TodoDto todoDto) {
        todoListService.createTodo(todoDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/userId")
    public List<Todo> getTodoListByUserId(String userId) {
        return todoListService.getTodoListByUserId(userId);

    }

    @DeleteMapping("/id")
    public void deleteById(@RequestParam String id) {
        todoListService.deleteById(id);
    }

    @GetMapping("/id")
    public Optional<Todo> getTodoListById(@RequestParam String id) {
        return todoListService.getTodoListById(id);
    }

}
