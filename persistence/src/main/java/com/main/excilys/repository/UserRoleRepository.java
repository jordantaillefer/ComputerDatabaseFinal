package com.main.excilys.repository;

import java.util.List;
import java.util.Optional;

import com.main.excilys.model.UserRole;

public interface UserRoleRepository {

    /**
     * save or update the given userRole in the database.
     * @param userRole the userRole to save/update.
     * @return the userRoel saved/updated
     */
    Optional<UserRole> save(UserRole userRole);

    List<UserRole> findRolesForOneUser(String username);

}
