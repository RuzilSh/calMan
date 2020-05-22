package com.mycalories.caloriesmanagement;

import com.mycalories.caloriesmanagement.model.Meal;
import com.mycalories.caloriesmanagement.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MealRepository mealRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
         mealRepository.save(new Meal(LocalDateTime.of(2020,1,25,13,15), "sandwich", 700));
         mealRepository.save(new Meal(LocalDateTime.of(2020,1,25,20,00), "ice cream", 400));
         mealRepository.save(new Meal(LocalDateTime.of(2020,1,25,23,30), "breakfast", 750));
         mealRepository.save(new Meal(LocalDateTime.of(2020,2,14,9,30), "lunch", 1000));
         mealRepository.save(new Meal(LocalDateTime.of(2020,2,14,15,15), "yummy", 700));
         mealRepository.save(new Meal(LocalDateTime.of(2020,2,14,20,00), "dinner", 800));
         mealRepository.save(new Meal(LocalDateTime.of(2020,3,5,6,45), "pizza", 1000));
         mealRepository.save(new Meal(LocalDateTime.of(2020,3,5,16,15), "soup", 500));
         mealRepository.save(new Meal(LocalDateTime.of(2020,3,5,23,30), "burrito", 400));
         mealRepository.save(new Meal(LocalDateTime.of(2020,4,30,10,45), "chicken", 600));
         mealRepository.save(new Meal(LocalDateTime.of(2020,4,30,17,15), "hamburger", 800));
         mealRepository.save(new Meal(LocalDateTime.of(2020,4,30,20,30), "salad", 600));
         mealRepository.save(new Meal(LocalDateTime.of(2020,5,3,5,45), "spaghetti", 350));
         mealRepository.save(new Meal(LocalDateTime.of(2020,5,3,15,00), "hot dog", 450));
         mealRepository.save(new Meal(LocalDateTime.of(2020,5,3,22,15), "vegetables", 550));
    }
}
