package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import core.IAuthentication;
import core.impl.Authentication;
import core.impl.dao.UserDAO;
import core.model.User;

public class TestUser {

	@Test
	public void test() {
		
		UserDAO userDAO = new UserDAO();
		
		
		ArrayList<User> listUser = userDAO.listUser();
		
		System.out.println("Antes---------------");
		for (User user : listUser) {
			System.out.println(user.toString());
		}
		userDAO.insertUser(new User("JOAO", "1234"));
		
		System.out.println("Depois---------------");
		listUser = userDAO.listUser();
		
		for (User user : listUser) {
			System.out.println(user.toString());
		}
		
	}

}
