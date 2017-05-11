package com.main.excilys.presentation.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LinkTag extends SimpleTagSupport {

  private int page;
  private String label;
  private String type;
  private String search;
  private String column;
  private int nbObject;

  @Override
  public void doTag() throws JspException, IOException {
    JspWriter out = this.getJspContext().getOut();
    out.println("<li><a href='dashboard?page=" + page + "&column=" + column + "&search=" + search
        + "&nbObject=" + nbObject + "'aria-label='" + type + "' id='" + type
        + "'><span aria-hidden='true'>" + label + "</span></a></li>");
  }

  public void setPage(int page) {
    this.page = page;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setColumn(String column) {
    this.column = column;
  }

  public void setSearch(String search) {
    this.search = search;
  }

  public void setNbObject(int nbObject) {
    this.nbObject = nbObject;
  }

}
