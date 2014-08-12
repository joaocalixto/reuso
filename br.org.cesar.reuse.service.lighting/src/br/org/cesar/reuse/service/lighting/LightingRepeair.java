package br.org.cesar.reuse.service.lighting;

import java.util.List;

import br.org.cesar.reuse.commons.model.Repair;

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

		atributesList.add("Tipo da Ilumina��o");

		return atributesList;
	}
}
