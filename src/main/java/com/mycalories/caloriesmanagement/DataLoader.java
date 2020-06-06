package com.mycalories.caloriesmanagement;

import com.mycalories.caloriesmanagement.controller.SecurityUtil;
import com.mycalories.caloriesmanagement.model.Meal;
import com.mycalories.caloriesmanagement.model.User;
import com.mycalories.caloriesmanagement.repository.MealRepository;
import com.mycalories.caloriesmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MealRepository mealRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
         userRepository.save(new User(SecurityUtil.USER_CALORIES));
         mealRepository.save(new Meal(LocalDateTime.of(2020,1,7,13,15), "Sichuan Pork", 700));
         mealRepository.save(new Meal(LocalDateTime.of(2020,1,7,20,00), "Hot pot", 400));
         mealRepository.save(new Meal(LocalDateTime.of(2020,1,7,23,30), "Braised pork balls in gravy", 750));
         mealRepository.save(new Meal(LocalDateTime.of(2020,2,14,9,30), "Tandoori Chicken", 1000));
         mealRepository.save(new Meal(LocalDateTime.of(2020,2,14,15,15), "Murg Makhani", 700));
         mealRepository.save(new Meal(LocalDateTime.of(2020,2,14,20,00), "Tuna sandwich", 800));
         mealRepository.save(new Meal(LocalDateTime.of(2020,3,21,6,45), "Yummy pizza", 1000));
         mealRepository.save(new Meal(LocalDateTime.of(2020,3,21,16,15), "Apple Pie", 500));
         mealRepository.save(new Meal(LocalDateTime.of(2020,3,21,23,30), "Burrito", 400));
         mealRepository.save(new Meal(LocalDateTime.of(2020,4,30,10,45), "Mediterranean salad", 600));
         mealRepository.save(new Meal(LocalDateTime.of(2020,4,30,17,15), "French fries", 800));
         mealRepository.save(new Meal(LocalDateTime.of(2020,4,30,20,30), "Spaghetti with shrimp", 700));
         mealRepository.save(new Meal(LocalDateTime.of(2020,5,25,5,45), "Seaweed salad", 350));
         mealRepository.save(new Meal(LocalDateTime.of(2020,5,25,15,00), "Sushi", 450));
         mealRepository.save(new Meal(LocalDateTime.of(2020,5,25,22,15), "Miso soup", 550));
    }
}
