package com.main.excilys.service;

import com.main.excilys.mapper.ComputerToDtoMapper;
import com.main.excilys.model.Computer;
import com.main.excilys.model.dto.ComputerDto;
import com.main.excilys.repository.ComputerRepository;
import com.main.excilys.util.OptionValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Repository;

@Repository
public class ComputerService {

  @Autowired
  private ComputerRepository computerRepository;

  /**
   * Return an instance of computer selected by his id.
   *
   * @param idToSelect
   *          the id of the selected computer
   * @return the computer selected
   */
  public ComputerDto getComputerById(long idToSelect) {
    return ComputerToDtoMapper.toComputerDto(computerRepository.findOne(idToSelect));
  }

  /**
   * Creation of a new computer.
   *
   * @param newComputer
   *          the computer to create
   * @return the generated id of the computer
   */
  public long createComputer(ComputerDto newComputer) {
    return computerRepository.save(ComputerToDtoMapper.toComputer(newComputer)).getId();
  }

  /**
   * return the number of computer.
   *
   * @param options
   *          the options of the selected list
   * @return the number of computer
   */
  public long getNbComputer(Map<String, String> options) {
    OptionValidator.validate(options);
    return computerRepository.count();
  }

  /**
   * Delete a computer.
   *
   * @param idToDelete
   *          the id of the computer to delete
   */

  public void deleteComputer(long idToDelete) {
    computerRepository.delete(idToDelete);
  }

  /**
   * Update the computer.
   *
   * @param computer
   *          the computer to update
   */

  public void updateComputer(ComputerDto computer) {
    computerRepository.save(ComputerToDtoMapper.toComputer(computer));
  }

  /**
   * Get the computer provided by the page.
   *
   * @param numPage
   *          numPage
   * @param nbObjectToGet
   *          number of item to get
   * @param options
   *          the options of the selected list
   * @return list of item provided by the page
   */
  public List<ComputerDto> getComputerInRange(int numPage, int nbObjectToGet,
      Map<String, String> options) {
    OptionValidator.validate(options);

    Sort sort = options.get("column") != null && !options.get("column").isEmpty()
        ? new Sort(new Order(Direction.ASC, options.get("column")))
        : new Sort(new Order(Direction.ASC, "id"));
    PageRequest pageRequest = new PageRequest(numPage, nbObjectToGet, sort);
    Page<Computer> pageComputer = computerRepository.findByNameStartingWith(options.get("search"),
        pageRequest);
    List<ComputerDto> listAllComputerDto = new ArrayList<>();
    pageComputer
        .forEach(computer -> listAllComputerDto.add(ComputerToDtoMapper.toComputerDto(computer)));

    return listAllComputerDto;
  }

  /**
   * Get all computer.
   *
   * @return list of all computer
   */
  public List<ComputerDto> getAllComputer() {
    List<ComputerDto> listAllComputerDto = new ArrayList<>();
    computerRepository.findAll()
        .forEach(computer -> listAllComputerDto.add(ComputerToDtoMapper.toComputerDto(computer)));
    return listAllComputerDto;
  }

}
