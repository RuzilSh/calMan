package com.mycalories.caloriesmanagement.controller;

import com.mycalories.caloriesmanagement.domain.Meal;
import com.mycalories.caloriesmanagement.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/meals")
public class MealController {
    @Autowired
    MealRepository repository;

    @GetMapping
    public String getMeals(Map<String, Object> model){
        model.put("meals", repository.findAll());
        return "MealsPage";
    }

    @PostMapping
    public String addMeal(@RequestParam String description, @RequestParam Integer calories){
        repository.save(new Meal(description, calories));
        return "redirect:/meals";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteMeal(@PathVariable int id){
         repository.deleteById(id);
         return "redirect:/meals";
    }

}

