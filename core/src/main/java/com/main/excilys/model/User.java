package com.main.excilys.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -3882079512414316136L;

  @Id
  @Pattern(regexp = "^[a-zA-Z0-9 ._-]+$", message = "The name need at least one char or number")
  private String username;
  private String password;
  private boolean enabled;

  public User(String username, String password, boolean enabled) {
    this.username = username;
    this.password = password;
    this.enabled = enabled;
  }

  public User() {
  }
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
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (enabled ? 1231 : 1237);
    result = prime * result + (password == null ? 0 : password.hashCode());
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
    User other = (User) obj;
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
    if (username == null) {
      if (other.username != null) {
        return false;
      }
    } else if (!username.equals(other.username)) {
      return false;
    }
    return true;
  }
  @Override
  public String toString() {
    return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
  }

}
