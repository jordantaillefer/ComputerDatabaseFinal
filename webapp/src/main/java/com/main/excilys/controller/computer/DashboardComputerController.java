package com.main.excilys.controller.computer;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.main.excilys.presentation.Page;
import com.main.excilys.request.DashboardComputerRequest;
import com.main.excilys.response.DashboardComputerResponse;
import com.main.excilys.service.ComputerService;

@Controller
public class DashboardComputerController {

    @Autowired
    private DashboardComputerResponse dashboardResponse;

    @Autowired
    private ComputerService           computerService;

    /**
     * Dashboard mapping.
     *
     * @return the view
     */
    @GetMapping(value = "/dashboard")
    public ModelAndView doGet(@Valid @ModelAttribute DashboardComputerRequest dashboardRequest,
            BindingResult result) {
        ModelAndView model = new ModelAndView();
        model.setViewName("dashboard");

        dashboardResponse.fill(dashboardRequest);
        System.out
                .println(DashboardComputerController.class + " : " + dashboardRequest.getSearch());
        if (dashboardRequest.getSearch() != null && !dashboardRequest.getSearch().equals("")) {
            Map<String, String> options = new HashMap<>();
            options.put("column", "");
            options.put("search", dashboardRequest.getSearch());
            int nbComputer = (int) computerService.getNbComputer(options);
            model.addObject("nbComputerDto", nbComputer);
        } else {
            model.addObject("nbComputerDto", Page.nbObject);
        }
        model.addObject("model", dashboardResponse);


        return model;
    }

}
