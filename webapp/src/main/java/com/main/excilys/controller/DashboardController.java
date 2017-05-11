package com.main.excilys.controller;

import com.main.excilys.presentation.Page;
import com.main.excilys.request.DashboardRequest;
import com.main.excilys.response.DashboardResponse;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

  @Autowired
  private DashboardResponse dashboardResponse;

  /**
   * Dashboard mapping.
   *
   * @return the view
   */
  @GetMapping(value = "/dashboard")
  public ModelAndView doGet(@Valid @ModelAttribute DashboardRequest dashboardRequest,
      BindingResult result) {

    ModelAndView model = new ModelAndView();
    model.setViewName("dashboard");

    dashboardResponse.fill(dashboardRequest);

    model.addObject("model", dashboardResponse);
    model.addObject("nbComputerDto", Page.nbObject);

    return model;
  }

}
