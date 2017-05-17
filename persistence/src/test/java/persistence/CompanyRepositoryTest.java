package persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.main.excilys.PersistenceContext;
import com.main.excilys.model.Company;
import com.main.excilys.repository.CompanyRepository;
import com.main.excilys.repository.DaoException;

import java.util.List;

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
public class CompanyRepositoryTest {

  @Autowired
  private CompanyRepository companyRepository;

  private Company company;

  @Before
  public void beforeEachTest() {

    company = new Company();
    company.setId(1);
    company.setName("Apple Inc.");

  }

  /**
   */
  @After
  public void afterEachTest() {

    company = null;
  }

  // FIND

  @Test
  public void getAllCompaniesShouldReturn42Companies() {
    List<Company> companies = companyRepository.findAll();
    assertEquals(companies.size(), 42);
  }

  @Test
  public void getCompanyByIdShouldReturnCompany() {
    Company companyFound = companyRepository.findOne(1L).get();
    assertTrue(companyFound.equals(company));
  }

  // DELETE

  @Test(expected = DaoException.class)
  @Transactional
  public void deleteCompanyShouldThrowExceptionBecauseIdisInvalid() {
    companyRepository.delete(-1L);
  }

}
