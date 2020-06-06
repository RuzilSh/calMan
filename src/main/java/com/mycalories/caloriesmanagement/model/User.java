package com.mycalories.caloriesmanagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "u")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private Integer dailyCalorieLimit;
    @OneToMany(mappedBy = "user")
    private List<Meal> mealList;


    public User() {
    }

    public User(Integer dailyCalorieLimit) {
        this.dailyCalorieLimit = dailyCalorieLimit;
    }

    public User(Integer id, Integer dailyCalorieLimit) {
        this.id = id;
        this.dailyCalorieLimit = dailyCalorieLimit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDailyCalorieLimit() {
        return dailyCalorieLimit;
    }

    public void setDailyCalorieLimit(Integer dailyCalorieLimit) {
        this.dailyCalorieLimit = dailyCalorieLimit;
    }

}
