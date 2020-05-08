package com.mycalories.caloriesmanagement.repository;

import com.mycalories.caloriesmanagement.domain.Meal;
import org.springframework.data.repository.CrudRepository;

public interface MealRepository extends CrudRepository<Meal, Integer>{

}
