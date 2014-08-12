package br.org.cesar.reuse.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.cesar.reuse.commons.service.IRepair;
import br.org.cesar.reuse.service.ServiceManager;

public class ServletServices extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		final ServiceManager serviceManager = Activator.getServiceManager();
			
		String value = request.getParameter(Util.PARAM_NAME);

		if (value != null) {

			IRepair serviceRepair = serviceManager.getService(value);
			String content = getPage(serviceRepair.getAtributes());

			response.getWriter().write(content);
		} else {

			String[] services = serviceManager.getServices().split(";");

			response.getWriter().write("<html><body> ");

			for (int i = 0; i < services.length; i++) {
				response.getWriter().write(getLink(services[i]));
			}

			response.getWriter().write("</body></html>");

		}
	}
	
	private String getLink(String content){
		return "<a href='"+ Util.PATH_SERVICES + Util.PARAM_EQUALS + content +"'> "+ content + "</a> <br>";
	}

	private String getPage(final List<String> atributeList) {
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("<!DOCTYPE html>");
		stringBuilder.append("<html>");

		stringBuilder.append("<head>");
		stringBuilder.append("</head>");

		stringBuilder.append("<body>");

		stringBuilder.append("<form>");

		for (final String atribute : atributeList) {
			stringBuilder.append(atribute + ": <input type=\"text\" name=\""
					+ atribute + "\"><br>");
		}

		stringBuilder.append("<input type=\"submit\" value=\"Submeter\">");

		stringBuilder.append("</form>");

		stringBuilder.append("</body>");

		stringBuilder.append("</html>");

		return stringBuilder.toString();
	}
}
