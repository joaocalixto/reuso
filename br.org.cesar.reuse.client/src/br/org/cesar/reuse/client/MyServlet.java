package br.org.cesar.reuse.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.cesar.reuse.service.ServiceManager;

public class MyServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServiceManager serviceManager = Activator.getServiceManager();
		
		resp.getWriter().write("<html><body>" + serviceManager.getServices() +"</body></html>");
	}

}
