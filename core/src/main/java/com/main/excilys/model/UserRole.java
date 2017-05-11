package com.main.excilys.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -7162415839880319209L;

  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  @Column(name = "user_role_id", updatable = false, nullable = false)
  private int userRoleId;

  @Pattern(regexp = "^[a-zA-Z0-9 ._-]+$", message = "The name need at least one char or number")
  private String username;
  private String role;

  public UserRole(String username, String role) {
    this.username = username;
    this.role = role;
  }
  public UserRole() {
  }
  public int getUserRoleId() {
    return userRoleId;
  }
  public void setUserRoleId(int userRoleId) {
    this.userRoleId = userRoleId;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }
  @Override
  public String toString() {
    return "UserRole [userRoleId=" + userRoleId + ", username=" + username + ", role=" + role + "]";
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (role == null ? 0 : role.hashCode());
    result = prime * result + userRoleId;
    result = prime * result + (username == null ? 0 : username.hashCode());
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
    UserRole other = (UserRole) obj;
    if (role == null) {
      if (other.role != null) {
        return false;
      }
    } else if (!role.equals(other.role)) {
      return false;
    }
    if (userRoleId != other.userRoleId) {
      return false;
    }
    if (username == null) {
      if (other.username != null) {
        return false;
      }
    } else if (!username.equals(other.username)) {
      return false;
    }
    return true;
  }

}
