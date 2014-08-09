package br.org.cesar.reuse.service;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

import br.org.cesar.reuse.commons.service.IRepair;
import br.org.cesar.reuse.commons.utility.Logger;

public class ServiceTrackerRepair implements ServiceTrackerCustomizer {

	private final ServiceManager serviceManager;
	private final BundleContext context;

	public ServiceTrackerRepair(final BundleContext context,
			final ServiceManager serviceManager) {
		this.context = context;
		this.serviceManager = serviceManager;
	}

	@Override
	public Object addingService(final ServiceReference arg0) {
		final IRepair serviceRepair = (IRepair) context.getService(arg0);
		serviceManager.addService(serviceRepair);

		Logger.log("tracker service ... " + serviceRepair.getClass().getName());

		return serviceRepair;
	}

	@Override
	public void modifiedService(final ServiceReference arg0, final Object arg1) {
	}

	@Override
	public void removedService(final ServiceReference arg0, final Object arg1) {
		final IRepair repair = (IRepair) context.getService(arg0);
		serviceManager.removeService(repair);

	}
}
