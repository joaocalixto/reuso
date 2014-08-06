package br.org.cesar.reuse.service;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import br.org.cesar.reuse.commons.service.IRepair;

public class ServiceTrackerRepair implements ServiceTrackerCustomizer{
	
	private ServiceManager serviceManager;
	private BundleContext context;

	public ServiceTrackerRepair(BundleContext context, ServiceManager serviceManager) {
		this.context = context;
		this.serviceManager = serviceManager;
	}
	
	@Override
	public Object addingService(ServiceReference arg0) {

		IRepair serviceRepair = (IRepair) context.getService(arg0);
		serviceManager.addService(serviceRepair);
		
		System.out.println("tracker service ... "+ serviceRepair.getClass().getName());
		
		return serviceRepair;
	}

	@Override
	public void modifiedService(ServiceReference arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removedService(ServiceReference arg0, Object arg1) {
		IRepair repair = (IRepair) context.getService(arg0);
		serviceManager.removeService(repair);
		
	}

}
