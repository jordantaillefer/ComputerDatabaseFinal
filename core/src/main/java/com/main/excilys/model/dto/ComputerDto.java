package com.main.excilys.model.dto;

import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class ComputerDto {

  @NumberFormat(style = Style.NUMBER)
  private long id;

  @Pattern(regexp = "^[a-zA-Z0-9 ._-]+$", message = "The name need at least one char or number")
  private String name;

  @DateTimeFormat(iso = ISO.DATE)
  private String discontinued;

  @DateTimeFormat(iso = ISO.DATE)
  private String introduced;

  @NumberFormat(style = Style.NUMBER)
  private long companyId;

  private String companyName;

  /**
   * Constructor full param.
   *
   * @param id
   *          id
   * @param name
   *          name
   * @param discontinued
   *          discontinued
   * @param introduced
   *          introduced
   * @param companyId
   *          companyId
   * @param companyName
   *          companyName
   */
  public ComputerDto(long id, String name, String discontinued, String introduced, long companyId,
      String companyName) {
    super();
    this.id = id;
    this.name = name;
    this.discontinued = discontinued;
    this.introduced = introduced;
    this.companyId = companyId;
    this.companyName = companyName;
  }

  public ComputerDto() {

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDiscontinued() {
    return discontinued;
  }

  public void setDiscontinued(String discontinued) {
    this.discontinued = discontinued;
  }

  public void setIntroduced(String introduced) {
    this.introduced = introduced;
  }

  public String getIntroduced() {
    return introduced;
  }

  public long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(long companyId) {
    this.companyId = companyId;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  @Override
  public String toString() {
    return "ComputerDto [id=" + id + ", name=" + name + ", discontinued=" + discontinued
        + ", introduced=" + introduced + ", companyId=" + companyId + ", companyName=" + companyName
        + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (companyId ^ companyId >>> 32);
    result = prime * result + (companyName == null ? 0 : companyName.hashCode());
    result = prime * result + (discontinued == null ? 0 : discontinued.hashCode());
    result = prime * result + (int) (id ^ id >>> 32);
    result = prime * result + (introduced == null ? 0 : introduced.hashCode());
    result = prime * result + (name == null ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    ComputerDto other = (ComputerDto) obj;
    if (companyId != other.companyId) {
      return false;
    }
    if (companyName == null) {
      if (other.companyName != null) {
        return false;
      }
    } else if (!companyName.equals(other.companyName)) {
      return false;
    }
    if (discontinued == null) {
      if (other.discontinued != null) {
        return false;
      }
    } else if (!discontinued.equals(other.discontinued)) {
      return false;
    }
    if (id != other.id) {
      return false;
    }
    if (introduced == null) {
      if (other.introduced != null) {
        return false;
      }
    } else if (!introduced.equals(other.introduced)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }

}
