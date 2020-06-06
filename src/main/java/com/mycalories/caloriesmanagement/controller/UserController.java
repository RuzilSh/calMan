package com.mycalories.caloriesmanagement.controller;

import com.mycalories.caloriesmanagement.model.User;
import com.mycalories.caloriesmanagement.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {

    final
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/profile")
    public String update(@RequestParam(name = "dailyCalorieLimit") Integer dailyCalorieLimit){
        userRepository.save(new User(SecurityUtil.USER_ID, dailyCalorieLimit));
        return "redirect:/";
    }
}
