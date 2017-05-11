package com.main.excilys.rest;

import com.main.excilys.model.dto.ComputerDto;
import com.main.excilys.service.ComputerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputerRestController {
  @Autowired
  private ComputerService computerService;

  @GetMapping("/computers")
  public @ResponseBody List<ComputerDto> getAllComputer(@RequestParam("page") String page) {
    Map<String, String> options = new HashMap<>();

    options.put("column", "");
    options.put("search", "");
    return computerService.getComputerInRange(Integer.valueOf(page), 10, options);
  }

  @GetMapping("/computers/{id}")
  public @ResponseBody ComputerDto getComputerById(@PathVariable(value = "id") Long id) {
    return computerService.getComputerById(id);
  }

  @PostMapping("/computers")
  @Produces({ MediaType.APPLICATION_JSON })
  public ResponseEntity<ComputerDto> addComputer(@RequestBody ComputerDto computerDto) {
    computerService.createComputer(computerDto);
    return new ResponseEntity<>(computerDto, HttpStatus.OK);
  }

  @PutMapping("/computers")
  @Produces({ MediaType.APPLICATION_JSON })
  public ResponseEntity<ComputerDto> updateComputer(@RequestBody ComputerDto computerDto) {
    computerService.updateComputer(computerDto);
    return new ResponseEntity<>(computerDto, HttpStatus.OK);
  }

  @GetMapping("/computers/count")
  public @ResponseBody long getNbComputer() {
    Map<String, String> options = new HashMap<>();
    options.put("column", "");
    options.put("search", "");
    return computerService.getNbComputer(options);
  }

}
