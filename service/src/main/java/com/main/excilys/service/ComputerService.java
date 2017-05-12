package com.main.excilys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.excilys.mapper.ComputerToDtoMapper;
import com.main.excilys.model.Computer;
import com.main.excilys.model.dto.ComputerDto;
import com.main.excilys.repository.ComputerRepository;
import com.main.excilys.repository.FieldSort;
import com.main.excilys.util.OptionValidator;

@Repository
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    /**
     * Return an instance of computer selected by his id.
     *
     * @param idToSelect the id of the selected computer
     * @return the computer selected
     */
    public Optional<ComputerDto> getComputerById(long idToSelect) {
        Optional<Computer> computer = computerRepository.findOne(idToSelect);
        ComputerDto computerDto = null;
        if (computer.isPresent()) {
            computerDto = ComputerToDtoMapper.toComputerDto(computer.get());
        }
        return Optional.ofNullable(computerDto);
    }

    /**
     * Creation of a new computer.
     *
     * @param newComputer the computer to create
     * @return the generated id of the computer
     */
    public long createComputer(ComputerDto newComputer) {
        Optional<Computer> computer = computerRepository
                .save(ComputerToDtoMapper.toComputer(newComputer));
        if (computer.isPresent()) {
            return computer.get().getId();
        }
        return 0;
    }

    /**
     * return the number of computer.
     *
     * @param options the options of the selected list
     * @return the number of computer
     */
    public long getNbComputer(Map<String, String> options) {
        OptionValidator.validate(options);
        return computerRepository.countSearchByComputerName(options);
    }

    /**
     * Delete a computer.
     *
     * @param idToDelete the id of the computer to delete
     */

    public void deleteComputer(long idToDelete) {
        computerRepository.delete(idToDelete);
    }

    /**
     * Update the computer.
     *
     * @param computer the computer to update
     */

    public void updateComputer(ComputerDto computer) {
        computerRepository.save(ComputerToDtoMapper.toComputer(computer));
    }

    /**
     * Get the computer provided by the page.
     *
     * @param numPage numPage
     * @param nbObjectToGet number of item to get
     * @param options the options of the selected list
     * @return list of item provided by the page
     */
    public List<ComputerDto> getComputerInRange(int numPage, int nbObjectToGet,
            Map<String, String> options) {
        OptionValidator.validate(options);
        List<Computer> pageComputer = computerRepository.findByNameStartingWith(
                options.get("search"), numPage, nbObjectToGet,
                FieldSort.getFieldSort(options.get("column")));
        List<ComputerDto> listAllComputerDto = new ArrayList<>();
        pageComputer.forEach(
                computer -> listAllComputerDto.add(ComputerToDtoMapper.toComputerDto(computer)));

        return listAllComputerDto;
    }

    /**
     * Get all computer.
     *
     * @return list of all computer
     */
    public List<ComputerDto> getAllComputer() {
        List<ComputerDto> listAllComputerDto = new ArrayList<>();
        computerRepository.findAll().forEach(
                computer -> listAllComputerDto.add(ComputerToDtoMapper.toComputerDto(computer)));
        return listAllComputerDto;
    }

}
