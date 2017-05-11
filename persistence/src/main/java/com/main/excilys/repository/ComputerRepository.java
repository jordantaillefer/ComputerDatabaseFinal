package com.main.excilys.repository;

import com.main.excilys.model.Computer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {

  Page<Computer> findByNameStartingWith(String lastname, Pageable pageable);

}
