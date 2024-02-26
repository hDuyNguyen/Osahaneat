package com.spring.springbootpr.Controller;


import com.spring.springbootpr.Payload.Request.SignUpRequest;
import com.spring.springbootpr.Payload.ResponseData;
import com.spring.springbootpr.Service.imp.LoginServiceImp;
import com.spring.springbootpr.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
@SpringBootApplication(scanBasePackages = "com.spring.springbootpr")
public class LoginController {

    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/signin")   //do login cần bảo mật nên dùng phương thức POST
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password) {

        ResponseData responseData = new ResponseData();

        if (loginServiceImp.checkLogin(username, password)) {
            String token = jwtUtil.generateToken(username);
            responseData.setData(token);

        }
        else {
            responseData.setData("");
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {
        ResponseData responseData = new ResponseData();

        responseData.setData(loginServiceImp.addUser(signUpRequest));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
