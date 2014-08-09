package br.org.cesar.reuse.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

import br.org.cesar.reuse.commons.utility.Logger;
import br.org.cesar.reuse.service.ServiceManager;

public class Activator implements BundleActivator {

	private static BundleContext context;
	
	private ServiceTracker serviceTracker;
	
	static ServiceManager serviceManager;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		context = bundleContext;
		
		ServiceReference<HttpService> sr = context.getServiceReference(HttpService.class);
		HttpService http = (HttpService)context.getService(sr);
		
		if (http != null) {
			http.registerServlet("/ui", new MyServlet(), null, null);
			
			Logger.log("Servlet Registrado");
		}
		
		serviceTracker = new ServiceTracker<>(context, ServiceManager.class.getName(), null);
		serviceTracker.open();
		
		serviceManager = (ServiceManager) serviceTracker.getService();
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		context = null;
		serviceTracker.close();
	}
	
	public static ServiceManager getServiceManager(){
		return serviceManager;
	}
}
