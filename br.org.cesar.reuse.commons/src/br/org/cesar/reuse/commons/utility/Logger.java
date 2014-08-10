package br.org.cesar.reuse.commons.utility;

public final class Logger {

	private Logger() {

	}

	public static void log(final String message) {
		System.out.println(message);
	}

	public static <T> void log(final Class<T> someClass, final String message) {
		System.out.println(someClass.getSimpleName() + ": " + message);
	}

	public static void log(final Throwable e) {
		System.out.println(e.getMessage());
	}
}
