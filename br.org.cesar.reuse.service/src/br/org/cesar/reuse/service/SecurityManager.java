package br.org.cesar.reuse.service;

import authservice.IAuthentication;
import br.org.cesar.reuse.commons.model.User;

public class SecurityManager {

	public static IAuthentication auth;
	
	public static IAuthentication getInstanceIAuthentication(){
		return auth;
	}
	
	public boolean login(User user){
		return auth.login(user);
	}
	
	public void setAuth(IAuthentication authentication) {   
		auth = authentication;  
	}  
	public void unsetAuth(IAuthentication authentication) {   
		if (authentication == auth) {    
			auth = null;    
		}  
	} 

	
	
}
