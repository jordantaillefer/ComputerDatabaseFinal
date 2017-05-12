package com.main.excilys.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.main.excilys.model.Company;
import com.main.excilys.repository.CompanyRepository;
import com.main.excilys.repository.DaoException;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {
    private static final String HQL_SELECT_ALL_COMPANIES = "from Company";

    @PersistenceContext
    private EntityManager       session;

    @Override
    public List<Company> findAll() {
        List<Company> companies = (List<Company>) this.session
                .createQuery(HQL_SELECT_ALL_COMPANIES, Company.class).getResultList();
        return companies;
    }

    @Override
    public Optional<Company> findOne(long idToFind) {
        Company company = this.session.find(Company.class, idToFind);
        return Optional.ofNullable(company);
    }

    // TODO Count number of company searched by name
    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(long idToDelete) {
        try {
            Company company = this.session.find(Company.class, idToDelete);
            this.session.remove(company);
        } catch (IllegalArgumentException e) {
            throw new DaoException(e);
        }
    }

}
