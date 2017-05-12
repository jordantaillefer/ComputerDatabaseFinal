package com.main.excilys.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.main.excilys.model.UserRole;
import com.main.excilys.repository.UserRoleRepository;

@Repository
public class UserRoleRepositoryImpl implements UserRoleRepository {
    private static final String HQL_SELECT_ONE = "Select ur From UserRole as ur where ur.username like :username";

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

    @Override
    public List<UserRole> findRolesForOneUser(String username) {
        TypedQuery<UserRole> query = this.session.createQuery(HQL_SELECT_ONE, UserRole.class);
        username = username != null ? username : "";
        query.setParameter("username", username);
        return query.getResultList();
    }

}
