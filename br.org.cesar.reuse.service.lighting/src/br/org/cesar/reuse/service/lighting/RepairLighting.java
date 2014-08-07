package br.org.cesar.reuse.service.lighting;

import java.util.List;

import br.org.cesar.reuse.commons.service.IRepair;

public class RepairLighting implements IRepair {

	@Override
	public String getService() {
		String service = "Lighting Service";
		System.out.println(service);
		return service;
	}

	@Override
	public List<String> getAtributes() {
		// TODO Auto-generated method stub
		return null;
	}

}
