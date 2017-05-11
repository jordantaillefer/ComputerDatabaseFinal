package com.main.excilys.controller;

import com.main.excilys.model.dto.ComputerDto;
import com.main.excilys.service.CompanyService;
import com.main.excilys.service.ComputerService;
import com.main.excilys.util.ComputerDbException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditComputerController {
  @Autowired
  private CompanyService companyService;

  @Autowired
  private ComputerService computerService;

  @GetMapping(value = "/editComputer")
  protected ModelAndView doGet(@RequestParam("id") long id) {
    ModelAndView model = new ModelAndView();
    ComputerDto computerToEdit = computerService.getComputerById(id);
    model.setViewName("editComputer");
    model.addObject("computerToEdit", computerToEdit);
    model.addObject("listCompanyDto", companyService.getAllCompany());
    return model;

  }

  @PostMapping(value = "/editComputer")
  protected ModelAndView doPost(@Valid @ModelAttribute ComputerDto computerDto,
      BindingResult result) {
    ModelAndView model = new ModelAndView();
    // Toaster toast;
    try {
      computerService.updateComputer(computerDto);
    } catch (ComputerDbException e) {
      // toast = Toaster.INSTANCE.getToast(e.getMessage(), Toaster.ERROR, 3000);
      // req.setAttribute("toast", toast);
    }

    model.setViewName("editComputer");
    model.addObject("computerToEdit", computerDto);
    model.addObject("listCompanyDto", companyService.getAllCompany());
    return model;
  }

}