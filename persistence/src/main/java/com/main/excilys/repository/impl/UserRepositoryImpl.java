package com.main.excilys.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.main.excilys.model.User;
import com.main.excilys.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String HQL_SELECT_ALL_USERS          = "from User";
    private static final String HQL_SELECT_SEARCH_USER        = "Select u From User as u where u.username like :search";
    private static final String HQL_COUNT_USER_SEARCH_BY_NAME = "Select COUNT(u) From User as u where u.username like :search";
    private static final String HQL_SELECT_ONE                = "Select u From User as u where u.username like :username";

    @PersistenceContext
    private EntityManager       session;

    // TODO do the update case
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
        List<User> users = (List<User>) this.session.createQuery(HQL_SELECT_ALL_USERS, User.class)
                .getResultList();
        return users;
    }

    @Override
    public List<User> findByNameStartingWith(String search, int numPage, int nbObjectToGet) {
        String searchPattern = search != null ? search + "%" : "%";
        TypedQuery<User> query = this.session.createQuery(HQL_SELECT_SEARCH_USER, User.class)
                .setMaxResults(nbObjectToGet).setFirstResult(numPage * nbObjectToGet)
                .setParameter("search", searchPattern);
        return query.getResultList();
    }

    @Override
    public int countSearchByName(String search) {
        TypedQuery<Long> query = this.session.createQuery(HQL_COUNT_USER_SEARCH_BY_NAME,
                Long.class);
        String searchPattern = search != null ? search + "%" : "%";
        query.setParameter("search", searchPattern);
        return query.getResultList().get(0).intValue();
    }

    @Override
    public Optional<User> findOne(String username) {
        TypedQuery<User> query = this.session.createQuery(HQL_SELECT_ONE, User.class);
        username = username != null ? username : "";
        query.setParameter("username", username);
        User user = null;
        try {
            user = query.getResultList().get(0);
        } catch (IndexOutOfBoundsException e) {

        }
        return Optional.ofNullable(user);
    }

    @Override
    public void delete(String username) {
        Optional<User> user = this.findOne(username);
        if (user.isPresent()) {
            this.session.remove(user);
        }
    }

}
