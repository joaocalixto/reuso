package br.org.cesar.reuse.service.lighting;

import java.util.List;

import br.org.cesar.reuse.commons.service.IRepair;
import br.org.cesar.reuse.commons.utility.Logger;

public class RepairLighting implements IRepair {

	private static final String SERVICE = "Service: Lighting";
	
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
