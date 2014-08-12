package br.org.cesar.reuse.service.arborization;

import java.util.List;

import br.org.cesar.reuse.commons.service.IRepair;
import br.org.cesar.reuse.commons.utility.Logger;

public class RepairArborization implements IRepair {

	private static final String SERVICE = "ArborizationService";
	
	@Override
	public String getService() {
		Logger.log(SERVICE);
		
		return SERVICE;
	}

	@Override
	public List<String> getAtributes() {
		return null;
	}
}
