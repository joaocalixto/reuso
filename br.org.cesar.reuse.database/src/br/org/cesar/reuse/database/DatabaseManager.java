package br.org.cesar.reuse.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.org.cesar.reuse.commons.model.ArborizationRepair;
import br.org.cesar.reuse.commons.model.LightingRepeair;
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

	public void addUser(final User user) {
		userMap.put(user.getId(), user);
	}

	public void removeUser(final long id) {

		for (final Map.Entry<Long, User> entry : userMap.entrySet()) {

			if (entry.getValue().getId() == id) {
				userMap.remove(entry.getKey());
			}
		}
	}

	public void removeUser(final User user) {
		userMap.remove(user);
	}

	public void addRepair(final Repair repair) {
		repairMap.put(repair.getId(), repair);
	}

	public List<Repair> getAllRepair() {
		return new ArrayList<Repair>(repairMap.values());
	}

	public List<Repair> getAllRepair(final Class<? extends Repair> repairClass) {
		final List<Repair> repairList = new ArrayList<>();

		for (final Map.Entry<Long, Repair> entry : repairMap.entrySet()) {

			if (entry.getValue().getClass()
					.isAssignableFrom(repairClass)) {

				repairList.add(entry.getValue());

			} else if (entry.getValue().getClass()
					.isAssignableFrom(repairClass)) {

				repairList.add(entry.getValue());
			}
		}

		return repairList;
	}

	public void removeRepair(final long id) {

		for (final Map.Entry<Long, Repair> entry : repairMap.entrySet()) {

			if (entry.getValue().getId() == id) {
				repairMap.remove(entry.getKey());
			}
		}
	}

	public void removeRepair(final Repair repair) {
		repairMap.remove(repair);
	}
}
