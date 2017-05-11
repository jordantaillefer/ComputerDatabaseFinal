package com.main.excilys.repository;

/**
 * This exception might be thrown when an exception occur in the Dao.
 * @author Matthieu Lemaile
 */
public class DaoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Exception constructor.
     * @param message exception's message.
     */
    public DaoException(String message) {
        super(message);
    }

    /**
     * Exception constructor.
     * @param message exception's message
     * @param e root Exception.
     */
    public DaoException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * Exception constructor.
     * @param e root Exception.
     */
    public DaoException(Throwable e) {
        super(e);
    }

}
