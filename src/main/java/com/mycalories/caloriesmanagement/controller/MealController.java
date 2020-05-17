package com.mycalories.caloriesmanagement.controller;

import com.mycalories.caloriesmanagement.model.Meal;
import com.mycalories.caloriesmanagement.repository.MealRepository;
import com.mycalories.caloriesmanagement.to.MealTo;
import com.mycalories.caloriesmanagement.util.MealUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/meals")
public class MealController {
    final
    MealRepository repository;

    public MealController(MealRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getAllSorted(Model model) {
        final List<Meal> meals = repository.findAllByOrderByLocalDateTimeDesc();
        final List<MealTo> mealTos = MealUtil.convertAll(meals, 2000);
        model.addAttribute("meals", mealTos);
        return "list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        repository.deleteById(id);
        return "redirect:/meals";
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Nullable LocalDate startDate,
                         @RequestParam(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Nullable LocalDate endDate, Model model) {
        LocalDateTime firstDate = startDate != null ? startDate.atStartOfDay() : LocalDateTime.of(1, 1, 1, 0, 0);
        LocalDateTime secondDate = endDate != null ? endDate.atStartOfDay().plusDays(1) : LocalDateTime.of(3000, 1, 1, 0, 0);
        final List<Meal> filteredByDate = repository.getFilteredByDate(firstDate, secondDate);
        List<MealTo> mealTos = MealUtil.convertAll(filteredByDate, 2000);
        model.addAttribute("meals", mealTos);
        return "list";
    }

    @PostMapping("/save")
    public String createOrUpdate(@RequestParam(name = "id", required = false) Integer id,
                                 @RequestParam(name = "localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime,
                                 @RequestParam(name = "description") String description,
                                 @RequestParam(name = "calories") Integer calories) {
        repository.save(new Meal(id, localDateTime, description, calories));
        return "redirect:/meals";
    }
}


