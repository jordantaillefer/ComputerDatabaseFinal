package com.main.excilys.repository;

import java.util.Optional;

import com.main.excilys.model.UserRole;

public interface UserRoleRepository {

    Optional<UserRole> save(UserRole userRole);

}
