package impl.Auth;

import java.util.ArrayList;

import authservice.IAuthentication;
import authservice.User;

public class Authenticator implements IAuthentication {

		@Override
		public boolean insertUser(User user, User insertUser) {
			
			boolean vRetorno = false;
			if(authenticate(user)) {
				UserDAO userDAO = new UserDAO();
				userDAO.insertUser(insertUser);
				vRetorno = true;
			}
			
			return vRetorno;
		}

		@Override
		public boolean login(User user) {
			return authenticate(user);
		}
		
		private boolean authenticate(User user) {
			UserDAO userDAO = new UserDAO();
			boolean vRetorno = false;
			
			ArrayList<User> listUser = userDAO.getUser(user);
			
			if(listUser != null && listUser.size() > 0) {
				listUser.get(0);
				vRetorno = true;
			}
			
			return vRetorno;
		}

	}