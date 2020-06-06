package com.mycalories.caloriesmanagement.repository;

import com.mycalories.caloriesmanagement.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
