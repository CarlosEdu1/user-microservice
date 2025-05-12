package com.ms.user.controllers;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/micro")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto, userModel);//vamos receber um dto, e converter para um model
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

}
