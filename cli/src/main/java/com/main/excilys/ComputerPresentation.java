package com.main.excilys;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.main.excilys.model.ComputerRest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComputerPresentation {
  private Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

  /**
   * Print a single computer details.
   *
   * @param idToSelect
   *          the id of the computer.
   * @throws ComputerDbException
   *           exception
   */
  public void printComputerDetails(long idToSelect) throws ComputerDbException {
    String url = "computers";
    Map<String, String> params = new HashMap<>();
    params.put("id", String.valueOf(idToSelect));
    String response = RestClient.doGet(url, params);
    System.out.println(response);
  }

  /**
   * Creation presentation of a computer.
   *
   * @throws ComputerDbException
   *           exception
   */

  public void createComputer() throws ComputerDbException {
    String regexName = "^[a-zA-Z][a-zA-Z .-][a-zA-Z .-]+$";
    String name;

    do {
      name = SecureInput.secureInputString("name");
      if (!name.matches(regexName)) {
        System.out.println("The name must be composed at least by 3 chars");
      }
    } while (!name.matches(regexName));

    LocalDate introduced = SecureInput.secureInputDate("introduced");
    LocalDate discontinued = SecureInput.secureInputDate("discontinued");
    // TODO replace with a company selection

    String url = "computers";
    ComputerRest newComputerRest = new ComputerRest(0L, name, introduced.toString(),
        discontinued.toString(), 1, "");
    String response = RestClient.doPost(url, newComputerRest);
    System.out.println(response + " computers");
  }

  /**
   * Print the number of computer.
   *
   * @throws ComputerDbException
   *           exception
   */

  public void countComputer() throws ComputerDbException {
    String url = "computers/count";
    String response = RestClient.doGet(url);
    System.out.println(response + " computers");

  }

  /**
   * Print the computer provided by the page.
   *
   * @throws ComputerDbException
   *           exception
   */
  public void listComputerByPage(long id) throws ComputerDbException {

    String url = "http://localhost:8080/ComputerDatabase/computers?page=%s";
    url = String.format(url, id);
    String response = RestClient.doGet(url);
    System.out.println(response + " computers");
    List<ComputerRest> arrResponse = new Gson().fromJson(response,
        new TypeToken<List<ComputerRest>>() {
        }.getType());
    arrResponse.forEach(computer -> System.out.println(computer));
  }

  /**
   * Presentation of the delete action of a computer.
   *
   * @param idToDelete
   *          id of the computer to delete
   * @throws ComputerDbException
   *           exception
   */
  public void deleteComputer(long idToDelete) throws ComputerDbException {
    logger.debug("deleteComputer : idToDelete = " + idToDelete);

  }

  /**
   * Update presentation of a computer.
   *
   * @param idToUpdate
   *          the id of the asked updated computer
   * @throws ComputerDbException
   *           exception
   */

  public void updateComputer(long idToUpdate) throws ComputerDbException {
    logger.debug("updateComputer : idToUpdate = " + idToUpdate);
    String url = "computers";
    Map<String, String> params = new HashMap<>();
    params.put("id", String.valueOf(idToUpdate));
    String response = RestClient.doGet(url, params);
    ComputerRest computer = new Gson().fromJson(response, ComputerRest.class);

    if (computer == null) {
      logger.debug("updateComputer : No computer has this id : " + idToUpdate);
      System.out.println("No computer has this id : " + idToUpdate);

    } else {
      int choix = 0;
      do {
        System.out.println("Which value of the computer N°" + idToUpdate + " you want to change ?");
        System.out.println(" 1 - name : " + computer.getName());
        System.out.println(" 2 - discontinued : " + computer.getDiscontinued());
        System.out.println(" 3 - introduced : " + computer.getIntroduced());
        System.out.println(" 4 - company id : " + computer.getCompanyId());
        System.out.println(" 5 - finish");

        choix = SecureInput.secureInputInt("choice");
        switch (choix) {
          case 1 :
            String newName;
            do {
              newName = SecureInput.secureInputString("name");
              if (!newName.matches(newName)) {
                System.out.println("The name must be composed at least by 3 chars");
              }
            } while (!newName.matches(newName));
            computer.setName(newName);
            break;
          case 2 :
            LocalDate dateNewDiscontinued = SecureInput.secureInputDate("new discontinued");
            computer.setDiscontinued(dateNewDiscontinued.toString());
            break;
          case 3 :
            LocalDate dateNewIntroduced = SecureInput.secureInputDate("new introduced");
            computer.setIntroduced(dateNewIntroduced.toString());
            break;
          case 4 :
            int newCompanyId = SecureInput.secureInputInt("new company id");
            computer.setCompanyId(newCompanyId);
            break;
          default :
            break;
        }
        if (choix < 5) {

          response = RestClient.doPut(url, computer);
          logger.debug("Computer n°" + idToUpdate + " has been modified to : " + computer);
          System.out.println("Computer N°" + idToUpdate + " updated !");
        }
      } while (choix != 5);
    }
  }

}