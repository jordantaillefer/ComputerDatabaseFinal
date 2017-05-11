package com.main.excilys.model.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

public class UserDto implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 5247560800346439312L;

  @Pattern(regexp = "^[a-zA-Z0-9 ._-]+$", message = "The name need at least one char or number")
  private String username;
  private String password;
  private boolean enabled;
  private String role;

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public boolean isEnabled() {
    return enabled;
  }
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }

  public UserDto(String username, String password, boolean enabled, String role) {
    super();
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.role = role;
  }
  public UserDto() {

  }
  @Override
  public String toString() {
    return "UserDto [username=" + username + ", password=" + password + ", enabled=" + enabled
        + ", role=" + role + "]";
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (enabled ? 1231 : 1237);
    result = prime * result + (password == null ? 0 : password.hashCode());
    result = prime * result + (role == null ? 0 : role.hashCode());
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
    UserDto other = (UserDto) obj;
    if (enabled != other.enabled) {
      return false;
    }
    if (password == null) {
      if (other.password != null) {
        return false;
      }
    } else if (!password.equals(other.password)) {
      return false;
    }
    if (role == null) {
      if (other.role != null) {
        return false;
      }
    } else if (!role.equals(other.role)) {
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
