package com.suraksha.studentmanagementapi.controller;
import com.suraksha.studentmanagementapi.dto.RegisterRequest;
import com.suraksha.studentmanagementapi.entity.User;
import com.suraksha.studentmanagementapi.service.AuthService;
import org.springframework.web.bind.annotation.*;
import com.suraksha.studentmanagementapi.dto.LoginRequest;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService=authService;
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request){
        return authService.register(request);
    }
}
