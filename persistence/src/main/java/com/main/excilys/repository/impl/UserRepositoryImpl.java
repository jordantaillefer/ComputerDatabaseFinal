package com.main.excilys.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.main.excilys.model.User;
import com.main.excilys.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String HQL_SELECT_ALL_USERS = "from User";

    @PersistenceContext
    private EntityManager session;

    @Override
    public Optional<User> save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("can't save a null object");
        }
        this.session.persist(user);
        this.session.flush();
        this.session.refresh(user);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        List<User> companies = (List<User>) this.session
                .createQuery(HQL_SELECT_ALL_USERS, User.class).getResultList();
        return companies;
    }

}
