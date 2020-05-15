package com.mycalories.caloriesmanagement.controller;

import com.mycalories.caloriesmanagement.domain.Meal;
import com.mycalories.caloriesmanagement.repository.MealRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/meals")
public class MealController {
    final
    MealRepository repository;

    public MealController(MealRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("meals", repository.findAll());
        return "list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
        return "redirect:/meals";
    }

    @GetMapping("/edit")
    public String update(@RequestParam(name = "id", required = false) Integer id, Model model) {
        if (id == null) {
            model.addAttribute("meal", new Meal());
            return "form";
        }
        Meal meal = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid meal Id:" + id));
        model.addAttribute("meal", meal);
        return "form";
    }

    @PostMapping("/save")
    public String save(@RequestParam(name = "id") Integer id, @RequestParam(name = "description") String description, @RequestParam(name = "calories") Integer calories) {
        repository.save(new Meal(id, description, calories));
        return "redirect:/meals";
    }

}


