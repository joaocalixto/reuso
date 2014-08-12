package br.org.cesar.reuse.service.lighting;

import java.util.List;

import br.org.cesar.reuse.commons.service.IRepair;
import br.org.cesar.reuse.commons.utility.Logger;

public class LightingService implements IRepair {

	private static final String SERVICE = "LightingService";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.org.cesar.reuse.commons.service.IRepair#getService()
	 */
	@Override
	public String getService() {
		Logger.log(SERVICE);

		return SERVICE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.org.cesar.reuse.commons.service.IRepair#getAtributes()
	 */
	@Override
	public List<String> getAtributes() {
		return LightingRepeair.getAtributes();
	}
}
