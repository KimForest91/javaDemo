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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



// Controller 를 붙이면 class - 함수를 불러오지 않아도 실행시켜줌
@Controller
@RequiredArgsConstructor
@RequestMapping("/users") // 기본 URL 경로 설정
public class UserController {    
    private final UserServiceImpl userService;     
    
    // 롬복쓰면 생성자 없어도 됨 대신 RequiredArgsConstructor 붙여줘야함
    // @Autowired    
    // public UserController(UserServiceImpl userService) {        
    //     this.userService = userService;    
    // }     
    

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


    @GetMapping("/example")
    // @ResponseBody
    String home(Model model) {
        return "example";
    }

    @PostMapping("/insert")
    public String setUsers(String name, String email, Model model) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        userService.insertUsers(newUser);

        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        // System.out.println("=========================delete id : " + id);
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        System.out.println("===============edit id : " + id);
        System.out.println("===============edit model : " + model);
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit-list";
    }

    @PostMapping("/update")
    public String updateUser(Long id, String name, String email) {
        User user = userService.getUserById(id);
        user.setName(name);
        user.setEmail(email);
        userService.updateUser(user);
        return "redirect:/users";
    }
    
    // @GetMapping("/insert")
    // public String setUsers(Model model) {
    //     User newUser = new User();
    //     newUser.setEmail("newsetEmail@naver.com");
    //     newUser.setName("NewName10000");
    //     userService.insertUsers(newUser);

    //     return this.getAllUsers(model);
    // }
}
