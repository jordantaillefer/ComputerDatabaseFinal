package com.main.excilys.repository;

import java.util.List;
import java.util.Optional;

import com.main.excilys.model.Company;

public interface CompanyRepository {

    List<Company> findAll();

    Optional<Company> findOne(long idToTest);

    long count();

    void delete(long idToDelete);

}
