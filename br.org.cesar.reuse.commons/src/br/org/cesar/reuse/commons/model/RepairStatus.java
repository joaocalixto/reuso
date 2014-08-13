package br.org.cesar.reuse.commons.model;

public enum RepairStatus {

	OPEN(1, "Aberto"), IN_PROGRESS(2, "Em Progresso"), CLOSED(3, "Fechado");

	private int id;
	private String name;

	private RepairStatus(final int id, final String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(final int id) {
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
}
