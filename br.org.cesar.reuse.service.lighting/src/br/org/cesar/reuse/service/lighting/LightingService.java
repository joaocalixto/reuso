package br.org.cesar.reuse.service.lighting;

import java.util.List;

import br.org.cesar.reuse.commons.model.Repair;
import br.org.cesar.reuse.commons.model.User;
import br.org.cesar.reuse.commons.service.IRepair;
import br.org.cesar.reuse.commons.utility.Logger;

public class LightingService implements IRepair {

	private static final String SERVICE = "LightingService";

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.org.cesar.reuse.commons.service.IRepair#getService()
	 */
	@Override
	public String getService() {
		Logger.log(SERVICE);

		return SERVICE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.org.cesar.reuse.commons.service.IRepair#getAtributes()
	 */
	@Override
	public List<String> getAtributes() {
		return LightingRepeair.getAtributes();
	}

	@Override
	public List<String> getAtributes(User user) {
		return LightingRepeair.getAtributes(user);
	}

	@Override
	public boolean requestRepair(Repair repair) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Repair> getRepairs() {
		// TODO Auto-generated method stub
		return null;
	}
}
