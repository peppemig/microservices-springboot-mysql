package it.peppe.userservice.controller;

import it.peppe.userservice.entity.User;
import it.peppe.userservice.service.UserService;
import it.peppe.userservice.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveuser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long userId){
        return userService.getUserWithDepartment(userId);
    }
}
