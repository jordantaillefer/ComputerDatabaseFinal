package com.main.excilys.repository.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.main.excilys.model.UserRole;
import com.main.excilys.repository.UserRoleRepository;

@Repository
public class UserRoleRepositoryImpl implements UserRoleRepository {

    @PersistenceContext
    private EntityManager session;

    // TODO implement the update behavior
    @Override
    public Optional<UserRole> save(UserRole userRole) {
        if (userRole == null) {
            throw new IllegalArgumentException("can't save a null object");
        }
        this.session.persist(userRole);
        this.session.flush();
        this.session.refresh(userRole);
        return Optional.ofNullable(userRole);
    }

}
