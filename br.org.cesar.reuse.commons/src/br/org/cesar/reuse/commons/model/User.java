package br.org.cesar.reuse.commons.model;

public class User {

	private long id;
	private String name;
	private String mail;
	private String password;
	private UserType type;

	/**
	 * @return the id
	 */
	public final long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(final long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the mail
	 */
	public final String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public final void setMail(final String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public final void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @return the type
	 */
	public final UserType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public final void setType(final UserType type) {
		this.type = type;
	}
}
