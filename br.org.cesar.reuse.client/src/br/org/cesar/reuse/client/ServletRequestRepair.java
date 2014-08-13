package br.org.cesar.reuse.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.cesar.reuse.commons.model.Repair;
import br.org.cesar.reuse.commons.model.User;
import br.org.cesar.reuse.commons.service.IRepair;
import br.org.cesar.reuse.service.ServiceManager;

public class ServletRequestRepair extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		final ServiceManager serviceManager = Activator.getServiceManager();
		
		final String value = request.getParameter(Util.PARAM_NAME);
		
		if (value != null){
			
			final IRepair serviceRepair = serviceManager.getService(value);
			Repair repair = (Repair) request.getAttribute(SessionState.REPAIR_REQUEST);
			
			boolean success = serviceRepair.requestRepair(repair);
			
			if (success){
				response.getWriter().write("<html><body> Servico Requisitado com Sucesso! <br> ");
				response.getWriter().write("</body></html>");
			}else{
				response.getWriter().write("<html><body> Falha ao requisitar o serviço! <br> ");
				response.getWriter().write("</body></html>");
			}
		}
	}
	

}
