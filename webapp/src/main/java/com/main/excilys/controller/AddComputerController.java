package com.main.excilys.controller;

import com.main.excilys.model.dto.ComputerDto;
import com.main.excilys.presentation.Page;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddComputerController {

  @Autowired
  private CompanyService companyService;

  @Autowired
  private ComputerService computerService;

  @GetMapping(value = "/addComputer")
  protected ModelAndView doGet() {
    ModelAndView model = new ModelAndView();
    model.setViewName("addComputer");
    model.addObject("listCompanyDto", companyService.getAllCompany());
    return model;

  }

  @PostMapping(value = "/addComputer")
  protected ModelAndView doPost(@Valid @ModelAttribute("computerDto") ComputerDto computerDto,
      BindingResult result) {
    if (result.hasErrors()) {
      result.getAllErrors().forEach(error -> System.out.println(error));
      return new ModelAndView("redirect:/addComputer");
    }

    this.doAddComputer(computerDto);

    return new ModelAndView("redirect:/addComputer");
  }

  private void doAddComputer(ComputerDto newComputerDto) {
    try {
      computerService.createComputer(newComputerDto);
      // long idCreate = computerService.createComputer(newComputerDto);
      // Toaster toast = Toaster.INSTANCE.getToast("Computer n°" + idCreate + " created !",
      // Toaster.SUCCESS, 3000);
      // req.setAttribute("toast", toast);
      Page.incrementNbObject();
    } catch (ComputerDbException e) {
      // Toaster toast = Toaster.INSTANCE.getToast(e.getMessage(), Toaster.ERROR, 3000);
      // req.setAttribute("toast", toast);
    }

  }

}
