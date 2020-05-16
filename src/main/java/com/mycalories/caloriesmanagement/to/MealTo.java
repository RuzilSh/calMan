package com.mycalories.caloriesmanagement.to;

import java.time.LocalDateTime;

public class MealTo {
    private Integer id;
    private LocalDateTime localDateTime;
    private String description;
    private Integer calories;
    private Boolean excess;


    public MealTo(Integer id, LocalDateTime localDateTime, String description, Integer calories, Boolean excess) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.description = description;
        this.calories = calories;
        this.excess = excess;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public void setExcess(Boolean excess) {
        this.excess = excess;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCalories() {
        return calories;
    }

    public Boolean getExcess() {
        return excess;
    }

    @Override
    public String toString() {
        return "MealTo{" +
                "id=" + id +
                ", ldt=" + localDateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", excess=" + excess +
                '}';
    }
}
