package authservice;

import br.org.cesar.reuse.commons.model.User;


public interface IAuthentication {
	
	boolean insertUser(User user, User insertUser);
	
	boolean login(User user);

}
