package com.main.excilys.mapper;

import com.main.excilys.model.Company;
import com.main.excilys.model.dto.CompanyDto;

public class CompanyToDtoMapper {

  /**
   * Pass a companyDto to a company.
   *
   * @param companyDto
   *          the data transfers representation of of a company
   * @return the corresponding company
   */
  public static Company toCompany(CompanyDto companyDto) {
    Company company = companyDto != null
        ? new Company(companyDto.getId(), companyDto.getName())
        : null;
    return company;
  }

  /**
   * Pass a company to a companyDto.
   *
   * @param company
   *          the company
   * @return the corresponding data transfers representation company
   */

  public static CompanyDto toCompanyDto(Company company) {
    CompanyDto companyDto = company != null
        ? new CompanyDto(company.getId(), company.getName())
        : null;
    return companyDto;
  }
}
