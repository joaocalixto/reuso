package br.org.cesar.reuse.commons.model;

import java.util.List;

public class LightingRepeair extends Repair {

	private String lightingType;

	/**
	 * @return the lightingType
	 */
	public final String getLightingType() {
		return lightingType;
	}

	/**
	 * @param lightingType
	 *            the lightingType to set
	 */
	public final void setLightingType(final String lightingType) {
		this.lightingType = lightingType;
	}

	public static List<String> getAtributes() {
		final List<String> atributesList = Repair.getAtributes();

		atributesList.add("Lighting_Type");

		return atributesList;
	}

	public static List<String> getAtributes(final User user) {
		final List<String> atributesList = Repair.getAtributes(user);

		atributesList.add("Lighting_Type");

		return atributesList;
	}
}
