package br.org.cesar.reuse.service.arborization;

import java.util.List;

import br.org.cesar.reuse.commons.service.IRepair;

public class RepairArborization implements IRepair {

	@Override
	public String getService() {
		String service = "Arborization Service";
		System.out.println(service);
		return service;
	}

	@Override
	public List<String> getAtributes() {
		// TODO Auto-generated method stub
		return null;
	}

}
