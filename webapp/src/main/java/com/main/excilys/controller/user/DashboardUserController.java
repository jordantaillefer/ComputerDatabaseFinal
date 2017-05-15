package com.main.excilys.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.main.excilys.model.dto.UserDto;
import com.main.excilys.service.UserService;

@Controller
public class DashboardUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/dashboardUser")
    public ModelAndView displayAllUsers() {
        ModelAndView model = new ModelAndView();
        List<UserDto> users = userService.findAll();
        model.addObject("nbUserDto", userService.countUsersSearchByName(null));
        model.addObject("users", users);
        model.setViewName("dashboardUser");
        return model;
    }

    @PostMapping("/dashboardUser")
    public ModelAndView promoteUser(String username) {
        if (username != null && !username.trim().isEmpty()) {
            userService.promoteUser(username);
        } else {
            // TODO Throw error to the view
        }
        return new ModelAndView("redirect;/dashboardUser");
    }

}
