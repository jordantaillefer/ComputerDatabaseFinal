package com.main.excilys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.excilys.mapper.CompanyToDtoMapper;
import com.main.excilys.model.Company;
import com.main.excilys.model.dto.CompanyDto;
import com.main.excilys.repository.CompanyRepository;

@Repository
public class CompanyService {

  @Autowired
  CompanyRepository companyRepository;

  /**
   * Method to get all the company.
   *
   * @return list of the company
   */
  public List<CompanyDto> getAllCompany() {
    List<CompanyDto> listCompanyDto = new ArrayList<>();
    companyRepository.findAll().forEach(company -> {
      CompanyDto companyDto = CompanyToDtoMapper.toCompanyDto(company);
      listCompanyDto.add(companyDto);
    });
    return listCompanyDto;
  }

  /**
   * Method to get a company by his id.
   *
   * @param idToTest
   *          the id of the selected company
   * @return the selected company
   */

    public Optional<CompanyDto> getCompanyById(long idToTest) {
        Optional<Company> company = companyRepository.findOne(idToTest);
        CompanyDto companyDto = null;
        if (company.isPresent()) {
            companyDto = CompanyToDtoMapper.toCompanyDto(company.get());
        }
        return Optional.ofNullable(companyDto);
  }

    // TODO get the number of company searched by name
  public long getNbCompany() {
    return companyRepository.count();
  }

  public void deleteCompanyById(long idToDelete) {
    companyRepository.delete(idToDelete);
  }

}
