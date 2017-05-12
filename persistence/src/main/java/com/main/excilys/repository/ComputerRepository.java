package com.main.excilys.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.main.excilys.model.Company;
import com.main.excilys.model.Computer;

public interface ComputerRepository {

    /**
     * Find a company with a given search name.
     * @param search a string to search computer
     * @param numPage the numero of the page to return
     * @param nbObjectToGet the number of object per page
     * @param sort the column to sort computer
     * @return a List of Computer
     */
    public List<Computer> findByNameStartingWith(String search, int numPage, int nbObjectToGet,
            FieldSort sort);

    /**
     * Find computers whose company name strart with search.
     * @param search the company's name of computer must start with thie string
     * @param numPage the numero of the page to return.
     * @param nbObjectToGet the number of element per page
     * @param sort the column to sort computers
     * @return a List of Computer
     */
    public List<Computer> findByCompanyNameStartingWith(String search, int numPage,
            int nbObjectToGet, FieldSort sort);

    /**
     * Find one computer int the database.
     * @param idToSelect the id of the computer to find
     * @return an optional of computer
     */
    Optional<Computer> findOne(long idToSelect);

    /**
     * Save or update the given computer in the database.
     * @param computer the computer to save/update
     * @return the computer saved/updated.
     */
    Optional<Computer> save(Computer computer);

    /**
     * Count the number of computer corresponding to the given search options.
     * @param options contains a "search" key with a value that computer's name must start with
     * @return the number of computer matching the research
     */
    long countSearchByComputerName(Map<String, String> options);

    /**
     * Count the number of computer corresponding to the given search options.
     * @param options contains a "search" key with a value that company's name of computer must
     *            start with
     * @return the number of computer matching the research
     */
    long countSearchByCompanyName(Map<String, String> options);

    /**
     * Delete the computer corresponding to the given id.
     * @param idToDelete the id of the computer to delete
     */
    void delete(long idToDelete);

    /**
     * return all computer in database. Be carefull, it might take a lot of time depending on the
     * amount of computer in the db.
     * @return a List of computer
     */
    List<Computer> findAll();

    /**
     * Delete all computer whose company is the given one.
     * @param company the company of computers to delete.
     */
    void deleteComputerByCompany(Company company);

}
