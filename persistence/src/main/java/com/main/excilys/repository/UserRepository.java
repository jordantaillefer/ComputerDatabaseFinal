package com.main.excilys.repository;

import java.util.List;
import java.util.Optional;

import com.main.excilys.model.User;

public interface UserRepository {

    Optional<User> save(User user);

    List<User> findAll();

}
