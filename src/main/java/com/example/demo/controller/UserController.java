package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserPhonesVO;
import com.example.demo.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Controller 를 붙이면 class - 함수를 불러오지 않아도 실행시켜줌
@Controller
@RequiredArgsConstructor
@RequestMapping("/users") // 기본 URL 경로 설정
public class UserController {    
    private final UserServiceImpl userService;     
    
    // @Autowired    
    // public UserController(UserServiceImpl userService) {        
    //     this.userService = userService;    
    // }     
    
    @GetMapping("/example")
    @ResponseBody
    String home() {
        return "<h1>ResponseBody 써보기</h1>";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id, Model model) {        
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-details";    // user-detail.html 반환
    }     
    
    @GetMapping // 모든 사용자 조회    
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list"; // user-list.html 반환
    }

    @GetMapping("/phones")
    public String getAllPhones(Model model) {
        List<UserPhonesVO> userPhones = userService.getAllUsersPhones();
        model.addAttribute("userPhones", userPhones);
        return "userPhones-list"; // userPhones-list.html 반환
    }
}
