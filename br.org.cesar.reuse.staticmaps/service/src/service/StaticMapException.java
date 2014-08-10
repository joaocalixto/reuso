package service;

public class StaticMapException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4494822857801216682L;

	String message;

	public StaticMapException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
