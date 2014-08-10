package br.org.cesar.reuse.commons.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import br.org.cesar.reuse.commons.utility.Logger;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		Logger.log(getClass(), "start()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		Logger.log(getClass(), "stop()");
	}
}
