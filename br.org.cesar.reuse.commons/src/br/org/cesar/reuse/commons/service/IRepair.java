package br.org.cesar.reuse.commons.service;

import java.util.List;

import br.org.cesar.reuse.commons.model.Repair;
import br.org.cesar.reuse.commons.model.User;

public interface IRepair {

	String getService();

	List<String> getAtributes();

	List<String> getAtributes(User user);

	boolean requestRepair(Repair repair);

	List<Repair> getRepairs();
}
