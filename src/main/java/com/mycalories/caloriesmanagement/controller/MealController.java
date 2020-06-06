package com.mycalories.caloriesmanagement.controller;

import com.mycalories.caloriesmanagement.model.Meal;
import com.mycalories.caloriesmanagement.model.User;
import com.mycalories.caloriesmanagement.repository.MealRepository;
import com.mycalories.caloriesmanagement.repository.UserRepository;
import com.mycalories.caloriesmanagement.to.MealTo;
import com.mycalories.caloriesmanagement.util.MealUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Controller
@Validated
public class MealController {
    final
    MealRepository mealRepository;

    final
    UserRepository userRepository;

    public MealController(MealRepository mealRepository, UserRepository userRepository) {
        this.mealRepository = mealRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String getAllSorted(Model model) {
        final List<Meal> meals = mealRepository.findAllByOrderByLocalDateTimeDesc();
        final List<MealTo> mealTos = MealUtil.convertAll(meals, userRepository.findById(SecurityUtil.USER_ID).get().getDailyCalorieLimit());
        User user= userRepository.findById(SecurityUtil.USER_ID).get();
        model.addAttribute("meals", mealTos);
        model.addAttribute("user", user);
        return "list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        mealRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Nullable LocalDate startDate,
                         @RequestParam(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Nullable LocalDate endDate,
                         @RequestParam(name = "startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) @Nullable LocalTime startTime,
                         @RequestParam(name = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) @Nullable LocalTime endTime,
                         Model model) {
        LocalDateTime date1 = startDate != null ? startDate.atStartOfDay() : LocalDateTime.of(1, 1, 1, 0, 0);
        LocalDateTime date2 = endDate != null ? endDate.atStartOfDay().plusDays(1) : LocalDateTime.of(3000, 1, 1, 0, 0);
        LocalTime time1 = startTime == null ? startTime.MIN : startTime;
        LocalTime time2 = endTime == null ? startTime.MAX : endTime;
        final List<Meal> filteredByDate = mealRepository.getFilteredByDate(date1, date2);
        List<MealTo> mealToFilteredByDate = MealUtil.convertAll(filteredByDate,userRepository.findById(SecurityUtil.USER_ID).get().getDailyCalorieLimit());
        List<MealTo> mealToFilteredByDateAndTime = mealToFilteredByDate.stream().filter(m -> (m.getLocalDateTime().toLocalTime().isAfter(time1)) && (m.getLocalDateTime().toLocalTime().isBefore(time2))).collect(Collectors.toList());
        model.addAttribute("meals", mealToFilteredByDateAndTime);
        User user = userRepository.findById((SecurityUtil.USER_ID)).get();
        model.addAttribute("user", user);
        return "list";
    }

    @PostMapping("/save")
    public String createOrUpdate(@RequestParam(name = "id", required = false) Integer id,
                                 @RequestParam(name = "localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime,
                                 @RequestParam(name = "description") String description,
                                 @RequestParam(name = "calories") Integer calories) {
        mealRepository.save(new Meal(id, localDateTime, description, calories));
        return "redirect:/";
    }
}


