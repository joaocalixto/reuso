package br.org.cesar.reuse.commons.model;

import java.util.List;

public class ArborizationRepair extends Repair {

	private String treeType;

	/**
	 * @return the treeType
	 */
	public final String getTreeType() {
		return treeType;
	}

	/**
	 * @param treeType
	 *            the treeType to set
	 */
	public final void setTreeType(final String treeType) {
		this.treeType = treeType;
	}

	public static List<String> getAtributes() {
		final List<String> atributesList = Repair.getAtributes();

		atributesList.add("Arborization_Type");

		return atributesList;
	}

	public static List<String> getAtributes(final User user) {
		final List<String> atributesList = Repair.getAtributes(user);

		atributesList.add("Arborization_Type");

		return atributesList;
	}
}
