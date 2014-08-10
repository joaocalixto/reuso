package br.org.cesar.reuse.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.org.cesar.reuse.commons.model.Repair;
import br.org.cesar.reuse.commons.model.User;

public class DatabaseManager {

	private final Map<Long, User> userMap = new HashMap<>();
	
	private final Map<Long, Repair> repairMap = new HashMap<>();
	
	static class LazyLoader {
		static final DatabaseManager INSTANCE = new DatabaseManager();                                               
	}
	
	public static DatabaseManager getInstance() {
		return LazyLoader.INSTANCE;
	}
	
	public void addUser(User user) {
		userMap.put(user.getId(), user);
	}
	
	public void removeUser(long id) {
		userMap.remove(id);
	}
	
	public void removeUser(User user) {
		userMap.remove(user);
	}
	
	public void addRepair(Repair repair) {
		repairMap.put(repair.getId(), repair);
	}
	
	public List<Repair> getAllRepair() {
		return new  ArrayList<Repair>(repairMap.values());
	}
	
	public void removeRepair(long id) {
		repairMap.remove(id);
	}
	
	public void removeRepair(Repair repair) {
		repairMap.remove(repair);
	}
}
