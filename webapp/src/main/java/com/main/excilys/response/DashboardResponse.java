package com.main.excilys.response;

import com.main.excilys.model.dto.ComputerDto;
import com.main.excilys.presentation.Page;
import com.main.excilys.request.DashboardRequest;
import com.main.excilys.service.ComputerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DashboardResponse {

  private Map<String, String> options = new HashMap<>();

  @Autowired
  private Page pageComputerDto;

  private List<ComputerDto> listComputerDto = new ArrayList<>();
  private final List<Integer> nbObjectAvailablePerPage = Arrays.asList(10, 50, 100);

  @Autowired
  private ComputerService computerService;

  public DashboardResponse() {
    super();
  }

  /**
   * fill the attributes.
   *
   * @param dashboardRequest
   *          the request model of the dashboard
   */
  public void fill(DashboardRequest dashboardRequest) {
    this.doSetOptions(dashboardRequest.getColumn(), dashboardRequest.getSearch());
    this.doSetNbComputer(dashboardRequest.getNbObject());
    this.doSetPage(dashboardRequest.getPage());
    this.setListComputer();
  }

  private void setListComputer() {
    listComputerDto = computerService.getComputerInRange(pageComputerDto.getPage(),
        pageComputerDto.getNbObjectPerPage(), options);
  }

  private void doSetPage(int page) {
    if (page >= 0 && page - 1 < pageComputerDto.getMaxPage()) {
      pageComputerDto.setPage(page);
    }
  }

  private void doSetNbComputer(int nbObject) {
    nbObject = nbObject != 0 ? nbObject : 10;
    pageComputerDto.setNbObjectPerPage(nbObject);
    pageComputerDto.setPage(0);
  }

  private void doSetOptions(String column, String search) {
    column = column != null ? column : "";
    search = search != null ? search : "";
    options.put("column", column);
    options.put("search", search);
  }

  public Map<String, String> getOptions() {
    return options;
  }

  public Page getPageComputerDto() {
    return pageComputerDto;
  }

  public List<ComputerDto> getListComputerDto() {
    return listComputerDto;
  }

  public List<Integer> getNbObjectAvailablePerPage() {
    return nbObjectAvailablePerPage;
  }

}
