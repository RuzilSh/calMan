package com.mycalories.caloriesmanagement.to;

import java.time.LocalDateTime;

public class MealTo {
    private final Integer id;
    private final LocalDateTime localDateTime;
    private final String description;
    private final Integer calories;
    private final Boolean excess;

    public MealTo(Integer id, LocalDateTime localDateTime, String description, Integer calories, Boolean excess) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.description = description;
        this.calories = calories;
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
