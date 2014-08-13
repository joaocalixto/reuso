package br.org.cesar.reuse.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.cesar.reuse.commons.model.User;
import br.org.cesar.reuse.service.ServiceManager;

public class ServletMain extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		final ServiceManager serviceManager = Activator.getServiceManager();
		
		String typeUser = request.getParameter(Util.PARAM_AUTH);
		
		if (typeUser != null){
			
			int type = Integer.parseInt(typeUser);
			
			if (type == Util.USER_LOGGED){
				//get Fields and valid
				boolean authenticated = serviceManager.login(new User());
				
				if (authenticated){
					SessionState.setTypeUserSession(request.getSession(),Util.USER_LOGGED);
					response.sendRedirect(Util.PATH_SERVICES);
				}

			} else if (type == Util.USER_ANONYMOUS){
				SessionState.setTypeUserSession(request.getSession(),Util.USER_ANONYMOUS);
				response.sendRedirect(Util.PATH_SERVICES);
			}
		}

		response.getWriter().write("<html><body> Welcome <br> ");
		response.getWriter().write("<a href='"+Util.PATH_MAIN + Util.PARAM_AUTH_EQUALS + Util.USER_ANONYMOUS +"'>Anonymous User</a><br> ");
		response.getWriter().write("<a href='"+Util.PATH_MAIN + Util.PARAM_AUTH_EQUALS + Util.USER_LOGGED +"'>Logged User</a><br> ");
		response.getWriter().write("</body></html>");

	}
}
