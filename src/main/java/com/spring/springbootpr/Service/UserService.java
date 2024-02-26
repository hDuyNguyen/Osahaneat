package com.spring.springbootpr.Service;

import com.spring.springbootpr.DTO.UserDTO;
import com.spring.springbootpr.Entity.Users;
import com.spring.springbootpr.Repository.UserRepository;
import com.spring.springbootpr.Service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUser() {
        List<Users> usersList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (Users users : usersList) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(users.getId());
            userDTO.setUsername(users.getUsername());
            userDTO.setPassword(users.getPassword());
            userDTO.setFullname(users.getFullname());

            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
