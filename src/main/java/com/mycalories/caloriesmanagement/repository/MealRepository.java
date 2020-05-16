package com.mycalories.caloriesmanagement.repository;

import com.mycalories.caloriesmanagement.domain.Meal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MealRepository extends CrudRepository<Meal, Integer>{
    List<Meal> findAllByOrderByLocalDateTimeDesc();

    @Query("SELECT m FROM Meal m WHERE m.localDateTime > :startDate AND m.localDateTime < :endDate ORDER BY m.localDateTime DESC")
    List<Meal> getFilteredByDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
