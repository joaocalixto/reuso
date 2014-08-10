package core;

import core.model.User;

public interface IAuthentication {
	
	boolean insertUser(User user, User insertUser);
	
	boolean login(User user);

}
