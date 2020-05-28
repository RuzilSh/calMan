package com.mycalories.caloriesmanagement.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer dailyCalorieLimit;


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
