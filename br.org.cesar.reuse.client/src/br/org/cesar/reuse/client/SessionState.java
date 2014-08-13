package br.org.cesar.reuse.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.org.cesar.reuse.commons.model.Repair;

public class SessionState {
	
	public static final String USER_SESSION = "user_session";
	public static final String REPAIR_REQUEST = "repair_session";
	
	public static void setTypeUserSession(HttpSession session, int userType){
		session.setAttribute(USER_SESSION, userType);
	}
	
	public static int getTypeUserSession(HttpSession session){
		return (Integer) session.getAttribute(USER_SESSION);
	}
	
	public static void setRepairRequest(HttpServletRequest request, Repair repair){
		request.setAttribute(REPAIR_REQUEST, repair);
	}
	
	public static Repair getRepairRequest(HttpServletRequest request){
		return (Repair) request.getAttribute(REPAIR_REQUEST);
	}
}
