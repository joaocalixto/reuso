package br.org.cesar.reuse.service;

import java.util.ArrayList;
import java.util.List;

import br.org.cesar.reuse.commons.model.Repair;
import br.org.cesar.reuse.commons.service.IRepair;

public class ServiceManager {
	
	List<IRepair> services = new ArrayList<IRepair>();
	
	public void addService(IRepair service){
		System.out.println("Add Service");
		services.add(service);
	}
	
	public void removeService(IRepair service){
		System.out.println("Remove Service");
		services.remove(service);
	}
	
	public String requestRepair(Repair repair){
		String result = "";
		for (IRepair repairService : services){
			 result = result + "; "+ repairService.getService();
		}
		return result;
	}

}
