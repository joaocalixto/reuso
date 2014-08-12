package br.org.cesar.reuse.service;

import java.util.ArrayList;
import java.util.List;

import br.org.cesar.reuse.commons.model.Repair;
import br.org.cesar.reuse.commons.service.IRepair;
import br.org.cesar.reuse.commons.utility.Logger;

public class ServiceManager {

	List<IRepair> services = new ArrayList<IRepair>();

	protected void addService(final IRepair service) {
		Logger.log("Add Service");
		services.add(service);
	}

	protected void removeService(final IRepair service) {
		Logger.log("Remove Service");
		services.remove(service);
	}

	public String requestRepair(final Repair repair) {
		String result = "";

		for (final IRepair repairService : services) {
			result = result + "; " + repairService.getService();
		}
		return result;
	}

	public String getServices() {
		final StringBuilder stringBuilder = new StringBuilder();

		for (final IRepair repairService : services) {
			stringBuilder.append(";"+repairService.getService());
		}
		
		return stringBuilder.delete(0, 1).toString();
	}
	
	public IRepair getService(String serviceName){
		
		for (final IRepair repairService : services) {
			if (repairService.getService().equals(serviceName)){
				return repairService;
			}
		}
		
		return null;
	}
}
