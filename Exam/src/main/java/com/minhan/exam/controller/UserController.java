package com.minhan.exam.controller;

import com.minhan.exam.dto.LoginDto;
import com.minhan.exam.dto.UserDto;
import com.minhan.exam.entity.UserEntity;
import com.minhan.exam.model.BaseResponse;
import com.minhan.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/public/login")
    public BaseResponse login(@RequestBody LoginDto loginDto) {
        BaseResponse res = new BaseResponse();
        UserEntity userEntity = userService.login(loginDto.getUsername(), loginDto.getPassword());
        if (userEntity == null) {
            res.message = "Username or password invalid";
        }else {
            res.status = 1;
            res.message = "Login success ";
            res.data = userEntity;
        }
        return res;
    }

    @PostMapping("/api/public/delete")
    public BaseResponse deleteUser(@RequestBody UserDto userDto){
        BaseResponse res = new BaseResponse();
        if(userDto.getId() > 0){
            userService.deleteUser(userDto.getId());
            res.status = 1;
            res.message = "Success";
        }else {
            res.message = "Id is not >0 ";
        }
        return res;
    }
}
