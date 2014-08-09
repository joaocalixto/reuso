package br.org.cesar.reuse.service.arborization;

import java.util.List;

import br.org.cesar.reuse.commons.service.IRepair;
import br.org.cesar.reuse.commons.utility.Logger;

public class RepairArborization implements IRepair {

	@Override
	public String getService() {
		String service = "Arborization Service";
		Logger.log(service);
		return service;
	}

	@Override
	public List<String> getAtributes() {
		return null;
	}
}
