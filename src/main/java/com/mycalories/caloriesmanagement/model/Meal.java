package com.mycalories.caloriesmanagement.model;


import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private LocalDateTime localDateTime;
    @Size(min = 2, max = 120)
    private String description;
    @Range(min = 10, max = 5000)
    private Integer calories;

    public Meal() {
    }

    public Meal(LocalDateTime localDateTime) {
        this(null, localDateTime, null, null);
    }

    public Meal(LocalDateTime localDateTime, String description, Integer calories) {
        this(null, localDateTime, description, calories);
    }

    public Meal(Integer id, LocalDateTime localDateTime, String description, Integer calories) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.description = description;
        this.calories = calories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public LocalDate getDate(){
        return localDateTime.toLocalDate();
    }
}
