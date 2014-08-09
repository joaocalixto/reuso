package br.org.cesar.reuse.service.lighting;

import java.util.List;

import br.org.cesar.reuse.commons.service.IRepair;
import br.org.cesar.reuse.commons.utility.Logger;

public class RepairLighting implements IRepair {

	@Override
	public String getService() {
		String service = "Lighting Service";
		Logger.log(service);
		return service;
	}

	@Override
	public List<String> getAtributes() {
		return null;
	}
}
