package com.main.excilys.presentation;

import com.main.excilys.service.ComputerService;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Page {
  private int page = 0;

  public static long nbObject;
  private int nbObjectPerPage = 10;
  private long maxPage;

  @Autowired
  private ComputerService computerService;

  /**
   * Simple constructor with the number of project.
   */
  @PostConstruct
  public void contruct() {
    CompletableFuture
        .supplyAsync(() -> Page.nbObject = computerService.getNbComputer(new HashMap<>()))
        .thenRun(() -> this.setMaxPage(Page.nbObject / nbObjectPerPage));
  }

  /**
   * Get the n° of the actual page.
   *
   * @return the n° of the actual page
   */
  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  /**
   * Switch to newPage.
   */

  public void nextPage() {
    this.page++;
  }

  /**
   * Try if the page has a next page.
   *
   * @return true if page has a next
   */
  public boolean hasNext() {
    if (this.page + 1 <= maxPage) {
      return true;
    }
    return false;
  }

  /**
   * Try if the page has a previous page.
   *
   * @return true if page has a previous
   */
  public boolean hasPrevious() {
    if (this.page - 1 >= 0) {
      return true;
    }
    return false;
  }

  /**
   * Switch to previousPage.
   */

  public void previousPage() {
    this.page--;
  }

  public int getNbObjectPerPage() {
    return nbObjectPerPage;
  }

  /**
   * Set the number of object per page.
   *
   * @param nbObjectPerPage
   *          the number of object
   */
  public void setNbObjectPerPage(int nbObjectPerPage) {
    this.nbObjectPerPage = nbObjectPerPage;
    this.setMaxPage(Page.nbObject / nbObjectPerPage);
  }

  public long getMaxPage() {
    return maxPage;
  }

  /**
   * Setter for the maxPage.
   *
   * @param l
   *          the maxPage to set
   */
  public void setMaxPage(long l) {
    if (nbObject != 0 && nbObject % nbObjectPerPage > 0) {
      this.maxPage = l;
    } else {
      this.maxPage = l - 1;
    }

  }

  public static void decrementNbObject() {
    nbObject--;

  }

  public static void incrementNbObject() {
    nbObject++;

  }
}
