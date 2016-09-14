package mapper.exceptions;

/**
 * Excepcion que lanza un mapper ante cualquier excepcion 
 * que se produzca durante el mapeo
 * 
 * @author atraspuesto
 *
 */
public class MappingException extends RuntimeException {

	public MappingException() {
		
	}

	public MappingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public MappingException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public MappingException(String message) {
		super(message);
		
	}

	public MappingException(Throwable cause) {
		super(cause);
		
	}
	
}
