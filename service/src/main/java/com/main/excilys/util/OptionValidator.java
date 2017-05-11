package com.main.excilys.util;

import java.util.Map;
import java.util.stream.Stream;

public enum OptionValidator {
  INSTANCE;

  /**
   * Method to validate that the options given to the DAO is correct. Correct values are search :
   * [String : [a-zA-Z][a-zA-Z -.][a-zA-Z -.]+]. sort : computer.name, computer.introduced,
   * computer.discontinued, company.name.
   *
   * @param options
   *          A map of options given to the DAO
   *
   */
  public static final void validate(Map<String, String> options) {
    options.forEach((key, value) -> {
      switch (key) {
        case "search" :
          if (!value.isEmpty() && value != null && !value.matches("^[a-zA-Z0-9 ._-]+$")) {
            options.remove(key);
            throw new ComputerDbException("The search value : " + value + " is incorrect");
          }
          break;
        case "column" :
          if (!value.isEmpty()) {
            String[] correctOptions = { "name", "introduced", "discontinued", "co.name" };
            if (!Stream.of(correctOptions).anyMatch(str -> str.equals(value.trim()))) {
              options.remove(key);
              throw new ComputerDbException("The sort value : " + value + " is incorrect");
            }
          }

          break;

        default :
          break;
      }
    });
  }
}
