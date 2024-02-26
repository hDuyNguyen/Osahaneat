package com.spring.springbootpr.Service;

import com.spring.springbootpr.DTO.UserDTO;
import com.spring.springbootpr.Entity.Roles;
import com.spring.springbootpr.Entity.Users;
import com.spring.springbootpr.Payload.Request.SignUpRequest;
import com.spring.springbootpr.Repository.UserRepository;
import com.spring.springbootpr.Service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class LoginService implements LoginServiceImp {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUser() {
        List<Users> usersList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (Users users: usersList) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(users.getId());
            userDTO.setUsername(users.getUsername());
            userDTO.setPassword(users.getPassword());
            userDTO.setFullname(users.getFullname());

            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public boolean checkLogin(String username, String password) {

        Users users = userRepository.findByUsername(username);

        return passwordEncoder.matches(password, users.getPassword());
    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {

        Roles roles = new Roles();
        roles.setId(signUpRequest.getRoleId());

        Users users = new Users();
        users.setFullname(signUpRequest.getFullname());
        users.setUsername(signUpRequest.getEmail());
        users.setPassword(signUpRequest.getPassword());
        users.setRoles(roles);

        try {
            userRepository.save(users);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
