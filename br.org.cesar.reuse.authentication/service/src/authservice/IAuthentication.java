package authservice;


public interface IAuthentication {
	
	boolean insertUser(User user, User insertUser);
	
	boolean login(User user);

}
