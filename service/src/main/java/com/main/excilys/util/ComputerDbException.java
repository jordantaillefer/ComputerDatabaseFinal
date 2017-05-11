package com.main.excilys.util;

/**
 * This Exception class is used to represent the exceptions thrown by the application.
 */
public class ComputerDbException extends RuntimeException {

  private static final long serialVersionUID = -1133013962801264530L;

  /**
   * Simple constructor.
   */
  public ComputerDbException() {
    super();
  }

  /**
   * Simple constructor with message.
   *
   * @param message
   *          message to throw
   */
  public ComputerDbException(String message) {
    super(message);
  }

  /**
   * Simple constructor with message and a throwable object.
   *
   * @param message
   *          message to throw
   * @param cause
   *          the throws exception
   */
  public ComputerDbException(String message, Throwable cause) {
    super(message, cause);
  }
  /**
   * Constructor with cause.
   *
   * @param cause
   *          the exception
   */

  public ComputerDbException(Throwable cause) {
    super(cause);
  }

}
