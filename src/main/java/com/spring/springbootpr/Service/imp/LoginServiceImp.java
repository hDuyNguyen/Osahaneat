package com.spring.springbootpr.Service.imp;

import com.spring.springbootpr.DTO.UserDTO;
import com.spring.springbootpr.Payload.Request.SignUpRequest;

import java.util.List;

public interface LoginServiceImp {
    List<UserDTO> getAllUser();
    boolean checkLogin(String username, String password);
    boolean addUser(SignUpRequest signUpRequest);
}
