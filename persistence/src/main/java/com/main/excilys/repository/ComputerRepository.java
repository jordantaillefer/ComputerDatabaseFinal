package com.main.excilys.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.main.excilys.model.Company;
import com.main.excilys.model.Computer;

public interface ComputerRepository {

    public List<Computer> findByNameStartingWith(String search, int numPage, int nbObjectToGet,
            FieldSort sort);

    public List<Computer> findByCompanyNameStartingWith(String search, int numPage,
            int nbObjectToGet, FieldSort sort);

    Optional<Computer> findOne(long idToSelect);

    Optional<Computer> save(Computer computer);

    long countSearchByComputerName(Map<String, String> options);

    long countSearchByCompanyName(Map<String, String> options);

    void delete(long idToDelete);

    List<Computer> findAll();

    void deleteComputerByCompany(Company company);

}
