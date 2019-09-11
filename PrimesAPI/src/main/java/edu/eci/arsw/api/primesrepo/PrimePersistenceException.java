package edu.eci.arsw.api.primesrepo;

public class PrimePersistenceException extends Exception{

    private static final long serialVersionUID = 1L;

	public PrimePersistenceException(String message) {
        super(message);
    }

    public PrimePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}