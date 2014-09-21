package br.org.cesar.reuse.commons.model;

import java.util.List;

public class CleanRepair extends Repair {

	private String cleanType;

	/**
	 * @return the cleanType
	 */
	public final String getCleanType() {
		return cleanType;
	}

	/**
	 * @param cleanType
	 *            the cleanType to set
	 */
	public final void setCleanType(final String cleanType) {
		this.cleanType = cleanType;
	}

	public static List<String> getAtributes() {
		final List<String> atributesList = Repair.getAtributes();

		atributesList.add("Clean_Type");

		return atributesList;
	}

	public static List<String> getAtributes(final User user) {
		final List<String> atributesList = Repair.getAtributes(user);

		atributesList.add("Clean_Type");

		return atributesList;
	}
}
