package com.main.excilys.rest;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.main.excilys.model.dto.CompanyDto;
import com.main.excilys.service.CompanyService;

@RestController
public class CompanyRestController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public ResponseEntity<List<CompanyDto>> getAllCompany() {
        return new ResponseEntity<>(companyService.getAllCompany(), HttpStatus.OK);
    }

    @GetMapping("/companies/{id}")
    @Produces({MediaType.APPLICATION_JSON })
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable(value = "id") Long id) {
        Optional<CompanyDto> company = companyService.getCompanyById(id);
        if (company.isPresent()) {
            return new ResponseEntity<>(company.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
