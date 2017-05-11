package com.main.excilys;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.excilys.model.CompanyRest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CompanyPresentation {
  private Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

  /**
   * Presentation of all the company.
   *
   * @throws ComputerDbException
   *           exception
   */

  public void listAllCompany() {
    String url = "companies";

    String response = RestClient.doGet(url);

    List<CompanyRest> arrResponse = null;
    try {
      arrResponse = new ObjectMapper().readValue(response, new TypeReference<List<CompanyRest>>() {
      });
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    arrResponse.forEach(company -> System.out.println(company));
    System.out.println(response);
  }

  /**
   * List the item collected by using the page information.
   *
   * @throws ComputerDbException
   *           exception
   *
   *
   *           public void listCompanyByPage(int numPage, int nbObject, int nbObjectPerPage) throws
   *           ComputerDbException { long idBegin = pageCompany.getNumPage() *
   *           Page.getNbObjectPerPage(); CompanyService.INSTANCE.getCompanyInRange(idBegin,
   *           Page.getNbObjectPerPage()) .forEach(company -> System.out.println(company)); }
   */

  /**
   * Atomic deletion of a company and all the computers linked.
   *
   * @param idToDelete
   *          the ID of the deleted company
   */
  public void deleteCompany(long idToDelete) {
    logger.debug("Action to delete company n°" + idToDelete);
    // companyService.deleteCompanyById(idToDelete);
  }

  public void getCompanyById(long idToSelect) {
    String url = "companies";
    String.format(url, idToSelect);

    Map<String, String> params = new HashMap<>();
    params.put("id", String.valueOf(idToSelect));
    String response = RestClient.doGet(url, params);
    System.out.println(response);
  }

}
