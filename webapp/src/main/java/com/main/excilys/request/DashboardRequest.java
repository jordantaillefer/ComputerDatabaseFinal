package com.main.excilys.request;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Component;

@Component
public class DashboardRequest {
  private String search;
  private String column;

  @NumberFormat(style = Style.NUMBER)
  private int page;

  @NumberFormat(style = Style.NUMBER)
  private int nbObject;

  /**
   * set the N° of the page.
   *
   * @param page
   *          the numero of the page
   */
  public void setPage(int page) {
    this.page = page;
  }

  public int getPage() {
    return page;
  }

  public String getColumn() {
    return column;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public String getSearch() {
    return search;
  }

  public void setSearch(String search) {
    this.search = search;
  }

  @Override
  public String toString() {
    return "DashboardRequest [search=" + search + ", column=" + column + ", page=" + page
        + ", nbObject=" + nbObject + "]";
  }

  public int getNbObject() {
    return nbObject;
  }

  /**
   * Set the number of object per page.
   *
   * @param nbObject
   *          the number of object
   */
  public void setNbObject(Integer nbObject) {
    nbObject = nbObject != null ? nbObject : 10;
    this.nbObject = nbObject;
  }

}
