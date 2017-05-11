package persistence;

import com.main.excilys.PersistenceContext;
import com.main.excilys.model.Company;
import com.main.excilys.model.Computer;
import com.main.excilys.repository.ComputerRepository;
import com.main.excilys.repository.DaoException;
import com.main.excilys.repository.FieldSort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceContext.class)
public class ComputerRepositoryTest {

	@Autowired
	private ComputerRepository computerRepository;

	private Computer computer;
	private Company company;

	@Before
	public void beforeEachTest() {

		company = new Company();
		company.setId(1);
		company.setName("Apple Inc.");

		computer = new Computer();
		computer.setName("iPhone 4S");
		computer.setIntroduced(LocalDate.of(2011, 10, 14));
		computer.setDiscontinued(null);
		computer.setCompany(company);

	}

	/**
	 */
	@After
	public void afterEachTest() {

		computer = null;
		company = null;
	}


	// CREATE


	@Test
	@Transactional
	public void createComputerShouldReturnGeneratedId() {
		long idGenerated = computerRepository.save(computer).get().getId();
		computer = new Computer();
		computer.setName("iPhone 4S");
		computer.setIntroduced(LocalDate.of(2011, 10, 14));
		computer.setDiscontinued(null);
		computer.setCompany(company);
		long idGenerated2 = computerRepository.save(computer).get().getId();
		assertEquals((idGenerated + 1), idGenerated2);
		computerRepository.delete(idGenerated);
		computerRepository.delete(idGenerated2);
	}

	@Test(expected=DaoException.class)
	@Transactional
	public void createComputerShouldThrowExceptionBecauseNameIsNull() {
		computer.setName(null);
		computerRepository.save(computer);
		computerRepository.delete(computer.getId());
	}

	@Test(expected=DaoException.class)
	@Transactional
	public void createComputerShouldThrowExceptionBecauseNameHasInvalidSymbols() {
		computer.setName("&)(\\$><");
		computerRepository.save(computer);
		computerRepository.delete(computer.getId());
	}

	@Test(expected=DaoException.class)
	@Transactional
	public void createComputerShouldThrowExceptionBecauseNameIsEmpty() {
		computer.setName("");
		computerRepository.save(computer);
		computerRepository.delete(computer.getId());
	}

	@Test(expected=DaoException.class)
	@Transactional
	public void createComputerShouldThrowExceptionBecauseIntroducedDateIsAfterDateDiscontinued() {
		computer.setIntroduced(LocalDate.of(2011, 10, 14));
		computer.setDiscontinued(LocalDate.of(2010, 10, 14));
		computerRepository.save(computer);
		computerRepository.delete(computer.getId());
	}

	@Test(expected=DaoException.class)
	@Transactional
	public void createComputerShouldThrowExceptionBecauseCompanyIdIsInvalid() {
		company.setId(-1);
		computerRepository.save(computer);
		computerRepository.delete(computer.getId());
	}

	//FIND 

	@Test
	public void getComputerByIdShouldReturnComputer() {
		computer.setId(574);
		Computer computerFound = computerRepository.findOne(computer.getId()).get();
		assertTrue(computerFound.equals(computer));
	}

	@Test
	public void getComputersByNameStartingWithMShouldReturnComputers() {
		List<Computer> computers = computerRepository.findByNameStartingWith("m", 0, 10, FieldSort.NAME);
		computer = new Computer();
		computer.setId(26);
		computer = computerRepository.findOne(computer.getId()).get();
		assertTrue(computers.get(0).equals(computer));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void getComputersByNameStartingWithMShouldRThrowExceptionBecauseNbObjectToGetIsInvalid() {
		List<Computer> computers = computerRepository.findByNameStartingWith("m", 8, 17, FieldSort.NAME);
		computer = new Computer();
		computer.setId(26);
		computer = computerRepository.findOne(computer.getId()).get();
		assertTrue(computers.get(0).equals(computer));
	}
	
	@Test(expected=DaoException.class)
	public void getComputersByNameStartingWithMShouldRThrowExceptionBecauseNumPageIsInvalid() {
		computerRepository.findByNameStartingWith("m", 8, 10, FieldSort.NAME);
	}
	
	@Test
	public void getAllComputersShouldReturn574Computers() {
		List<Computer> computers = computerRepository.findAll();
		assertEquals(computers.size(), 574);
	}



}