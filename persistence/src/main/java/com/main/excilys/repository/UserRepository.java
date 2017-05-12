package com.main.excilys.repository;

import java.util.List;
import java.util.Optional;

import com.main.excilys.model.User;

public interface UserRepository {

    Optional<User> save(User user);

    List<User> findAll();

    List<User> findByNameStartingWith(String search, int numPage, int nbObjecttoGet);

    int countSearchByName(String search);

    Optional<User> findOne(String username);

    void delete(String username);

}
