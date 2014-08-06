package br.org.cesar.reuse.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import br.org.cesar.reuse.commons.service.IRepair;

public class Activator implements BundleActivator {

	private static BundleContext context;
	
	public ServiceManager serviceManager = new ServiceManager();
	private ServiceTracker serviceTracker;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		
		context.registerService(ServiceManager.class.getName(), serviceManager, null);
		
		ServiceTrackerRepair myserviceTracker = new ServiceTrackerRepair(bundleContext, serviceManager);
		
		serviceTracker = new ServiceTracker(bundleContext, IRepair.class.getName(), myserviceTracker);
		serviceTracker.open();
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		serviceManager = null;
		serviceTracker.close();
	}

}
