package core.impl.dao;

import java.util.ArrayList;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import core.impl.util.EncriptUtil;
import core.model.User;

public class UserDAO {

	public void insertUser(User user) {

		ObjectContainer db = Db4o.openFile("database.db");

		try {
			user.setPass(EncriptUtil.encryptPassword(user.getPass()));
			db.store(user);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
	}

	public ArrayList<User> listUser() {
		User user = new User(null, null);
		ObjectContainer db = null;
		ArrayList<User> arrayList = new ArrayList<User>();
		try {
			db = Db4o.openFile("database.db");
			ObjectSet result = db.queryByExample(user);

			for (Object object : result) {
				User u = (User) object;
				arrayList.add(u);
			}

		} finally {
			db.close();
		}
		return arrayList;
	}
	
	
	public ArrayList<User> getUser(User user) {
		ObjectContainer db = null;
		ArrayList<User> arrayList = new ArrayList<User>();
		try {
			db = Db4o.openFile("database.db");
			ObjectSet result = db.queryByExample(user);

			for (Object object : result) {
				User u = (User) object;
				arrayList.add(u);
			}
		} finally {
			db.close();
		}
		return arrayList;
	}

	
	

	public void deleteAll() {

		ObjectContainer db = null;
		User retorno = null;
		try {
			db = Db4o.openFile("database.db");
			ObjectSet objects = db.queryByExample(null);
			for (Object object : objects) {
				db.delete(object);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
	}

	
}
