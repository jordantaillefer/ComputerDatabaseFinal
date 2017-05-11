package com.main.excilys.rest;

import com.main.excilys.model.dto.CompanyDto;
import com.main.excilys.service.CompanyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyRestController {

  @Autowired
  private CompanyService companyService;

  @GetMapping("/companies")
  public ResponseEntity<List<CompanyDto>> getAllCompany() {
    return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
  }

  @GetMapping("/companies/{id}")
  public @ResponseBody CompanyDto getCompanyById(@PathVariable(value = "id") Long id) {
    return companyService.getCompanyById(id);
  }

}
