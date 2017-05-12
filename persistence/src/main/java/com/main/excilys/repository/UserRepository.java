package com.main.excilys.repository;

import java.util.List;
import java.util.Optional;

import com.main.excilys.model.User;

public interface UserRepository {

    /**
     * save or update a user in the database.
     * @param user The user to save/update
     * @return the user aaved/updated.
     */
    Optional<User> save(User user);

    /**
     * find all user inthe database
     * @return a List of User
     */
    List<User> findAll();

    /**
     * find all user whose name starts with search, for the given page with nbObjectToGet user per
     * page.
     * @param search the username of user must start with search
     * @param numPage the numero of the page to return.
     * @param nbObjectToGet the number of element per page
     * @return a List of user
     */
    List<User> findByNameStartingWith(String search, int numPage, int nbObjectToGet);

    /**
     * Count the number of user whose username match the given search criteria.
     * @param search the username must start with search.
     * @return the number of user whose username starts with search
     */
    int countSearchByName(String search);

    /**
     * find a user whose name exactly match username.
     * @param username the username of the user to find.
     * @return the corresponding user
     */
    Optional<User> findOne(String username);

    /**
     * delete the user whose name exactly match username.
     * @param username the username of the user to delete
     */
    void delete(String username);

}
