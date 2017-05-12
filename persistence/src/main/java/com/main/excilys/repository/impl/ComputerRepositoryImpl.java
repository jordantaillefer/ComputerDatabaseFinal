package com.main.excilys.repository.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.main.excilys.model.Company;
import com.main.excilys.model.Computer;
import com.main.excilys.repository.ComputerRepository;
import com.main.excilys.repository.DaoException;
import com.main.excilys.repository.FieldSort;

@Repository
public class ComputerRepositoryImpl implements ComputerRepository {
    private static final String HQL_COUNT_COMPUTER_SEARCH_BY_COMPUTER         = "Select COUNT(c) From Computer as c where c.name like :search";
    private static final String HQL_COUNT_COMPUTER_SEARCH_BY_COMPANY          = "Select COUNT(c) From Computer as c left join c.company as company where company.name like :search";
    private static final String HQL_SELECT_ALL_COMPUTER                       = "From Computer";
    private static final String HQL_SELECT_COMPUTER_SEARCH_ORDER              = "Select c From Computer as c left join c.company as company where c.name like :search order by %s asc";
    private static final String HQL_SELECT_COMPUTER_SEARCH_COMPANY_NAME_ORDER = "Select c From Computer as c left join c.company as company where company.name like :search order by %s asc";
    private static final String HQL_DELETE_COMPUTER_BY_COMPANY                = "delete from Computer c where c.company = :company";
    private static final String HQL_SELECT_ONE_COMPUTER                       = "Select c From Computer as c where c.id like :id";

    @PersistenceContext
    private EntityManager       session;

    @Override
    public List<Computer> findByNameStartingWith(String search, int numPage, int nbObjectToGet,
            FieldSort sort) {
        String searchPattern = search != null ? search + "%" : "%";
        String hqlQuery = String.format(HQL_SELECT_COMPUTER_SEARCH_ORDER, "c." + sort.toString());
        TypedQuery<Computer> query = this.session.createQuery(hqlQuery, Computer.class)
                .setMaxResults(nbObjectToGet).setFirstResult(numPage * nbObjectToGet);
        query.setParameter("search", searchPattern);
        List<Computer> computers = query.getResultList();
        System.out.println(computers.size());
        return computers;
    }

    @Override
    public List<Computer> findByCompanyNameStartingWith(String search, int numPage,
            int nbObjectToGet, FieldSort sort) {
        String hqlQuery = String.format(HQL_SELECT_COMPUTER_SEARCH_COMPANY_NAME_ORDER,
                "c." + sort.toString());
        TypedQuery<Computer> query = this.session.createQuery(hqlQuery, Computer.class)
                .setMaxResults(nbObjectToGet).setFirstResult(numPage * nbObjectToGet);
        query.setParameter("search", search);
        return query.getResultList();
    }

    @Override
    public Optional<Computer> findOne(long idToSelect) {
        TypedQuery<Computer> query = this.session.createQuery(HQL_SELECT_ONE_COMPUTER,
                Computer.class);
        query.setParameter("id", idToSelect);
        Computer computer = query.getResultList().get(0);
        System.out.println("Id : " + idToSelect);
        // Computer computer = this.session.find(Computer.class, idToSelect);
        System.out.println(computer);
        return Optional.ofNullable(computer);
    }

    @Override
    public Optional<Computer> save(Computer computer) {
        if (computer == null) {
            throw new IllegalArgumentException("can't save a null object");
        }
        if (computer.getIntroduced() != null && computer.getDiscontinued() != null
                && computer.getIntroduced().isAfter(computer.getDiscontinued())) {
            throw new DaoException("Introduced date can't be after the discontinued");
        }
        if (computer.getCompany() != null && computer.getCompany().getId() < 0) {
            throw new DaoException("The company Id must be an existent one.");
        }
        Pattern pattern = Pattern.compile("[&|)|(|\\|$|>|<]");
        if (computer.getName() == null || computer.getName().trim().isEmpty()
                || pattern.matcher(computer.getName()).find()) {
            throw new DaoException("The computer name must be set and not contain invalid chars");
        }
        this.session.persist(computer);
        this.session.flush();
        this.session.refresh(computer);
        return Optional.ofNullable(computer);
    }

    @Override
    public void delete(long idToDelete) {
        Computer computer = this.session.find(Computer.class, idToDelete);
        this.session.remove(computer);
    }

    @Override
    public List<Computer> findAll() {
        TypedQuery<Computer> query = this.session.createQuery(HQL_SELECT_ALL_COMPUTER,
                Computer.class);
        return query.getResultList();
    }

    @Override
    public long countSearchByComputerName(Map<String, String> options) {

        TypedQuery<Long> query = this.session.createQuery(HQL_COUNT_COMPUTER_SEARCH_BY_COMPUTER,
                Long.class);
        String searchPattern = options.get("search") != null ? options.get("search") + "%" : "%";
        query.setParameter("search", searchPattern);
        return query.getResultList().get(0).intValue();
    }

    @Override
    public long countSearchByCompanyName(Map<String, String> options) {
        TypedQuery<Long> query = this.session.createQuery(HQL_COUNT_COMPUTER_SEARCH_BY_COMPANY,
                Long.class);
        String searchPattern = options.get("search") != null ? options.get("search") + "%" : "%";
        query.setParameter("search", searchPattern);
        return query.getResultList().get(0).intValue();
    }

    @Override
    public void deleteComputerByCompany(Company company) {
        this.session.createQuery(HQL_DELETE_COMPUTER_BY_COMPANY).setParameter("company", company)
                .executeUpdate();
    }

}
