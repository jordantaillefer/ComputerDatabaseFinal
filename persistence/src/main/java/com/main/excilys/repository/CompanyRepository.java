package com.main.excilys.repository;

import java.util.List;
import java.util.Optional;

import com.main.excilys.model.Company;

public interface CompanyRepository {

    /**
     * List all Companies
     * @return a List of all companies
     */
    List<Company> findAll();

    /**
     * Find one company
     * @param idToFind The id of the company you're looking for
     * @return an optional of company
     */
    Optional<Company> findOne(long idToFind);

    /**
     * Count the number of company in DB
     * @return 0 actually, must implement this.
     */
    long count();

    /**
     * Delete the given company
     * @param idToDelete The id of the company to delete
     */
    void delete(long idToDelete);

}
