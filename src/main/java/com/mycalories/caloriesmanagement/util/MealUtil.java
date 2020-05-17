package com.mycalories.caloriesmanagement.util;

import com.mycalories.caloriesmanagement.model.Meal;
import com.mycalories.caloriesmanagement.to.MealTo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MealUtil {

    private MealUtil() {
    }

    public static List<MealTo> convertAll(Collection<Meal> meals, int normalCalorieIntake){
        Map<LocalDate, Integer> caloriesSumPerDay = meals.stream().collect(Collectors.groupingBy(Meal::getDate, Collectors.summingInt(Meal::getCalories)));
        return meals.stream().map(meal -> creatTo(meal, caloriesSumPerDay.get(meal.getDate()) < normalCalorieIntake)).collect(Collectors.toList());
    }

    public static MealTo creatTo(Meal meal, boolean excess){
        return new MealTo(meal.getId(), meal.getLocalDateTime(), meal.getDescription(), meal.getCalories(), excess);
    }

}
