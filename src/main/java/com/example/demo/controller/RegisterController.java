package com.example.demo.controller;

import com.example.demo.controller.model.RegistrationDto;
import com.example.demo.entity.Account;
import com.example.demo.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/register")
@AllArgsConstructor
@RestController
public class RegisterController {

    private final RegisterService registerService;

    @GetMapping()
    public ResponseEntity<List<Account>> getAllToDoList() {
       return ResponseEntity.ok(registerService.getAllToDoList());
    }


    @PostMapping()
    public ResponseEntity createAccount(@RequestBody RegistrationDto registrationDto) {
        registerService.createAccount(registrationDto);
        return ResponseEntity.ok().build();
    }

}
