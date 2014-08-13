package br.org.cesar.reuse.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.cesar.reuse.commons.model.ArborizationRepair;
import br.org.cesar.reuse.commons.model.GeoMapData;
import br.org.cesar.reuse.commons.model.LightingRepeair;
import br.org.cesar.reuse.commons.model.Repair;
import br.org.cesar.reuse.commons.model.StaticMapException;
import br.org.cesar.reuse.commons.model.User;
import br.org.cesar.reuse.commons.service.IRepair;
import br.org.cesar.reuse.service.ServiceManager;

public class ServletServices extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String value;
	ServiceManager serviceManager;

	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		serviceManager = Activator.getServiceManager();

		value = request.getParameter(Util.PARAM_NAME);

		if (value != null) {

			int userType = SessionState
					.getTypeUserSession(request.getSession());

			final IRepair serviceRepair = serviceManager.getService(value);

			StringBuilder content = new StringBuilder();
			List<Repair> listRepairs = serviceRepair.getRepairs();

			if (userType == Util.USER_ANONYMOUS) {

				List<String> listAtributes = serviceRepair.getAtributes(null);
				content.append(getPage(listAtributes));
				content.append(getPageUserAnonymousList(listAtributes, listRepairs));

			} else if (userType == Util.USER_LOGGED) {
				List<String> listAtributes = serviceRepair
						.getAtributes(new User());

				content.append(getPage(listAtributes));
				content.append(getPageUserLoggedList(listAtributes, listRepairs));
			}

			content.append("</body>");
			content.append("</html>");

			response.getWriter().write(content.toString());

		} else {

			final String[] services = serviceManager.getServices().split(";");

			response.getWriter().write("<html><body> ");

			for (int i = 0; i < services.length; i++) {
				response.getWriter().write(getLink(services[i]));
			}

			response.getWriter().write("</body></html>");

		}
	}

	private String getLink(final String content) {
		return "<a href='" + Util.PATH_SERVICES + Util.PARAM_EQUALS + content
				+ "'> " + content + "</a> <br>";
	}

	private String getPage(final List<String> atributeList) {
		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("<!DOCTYPE html>");
		stringBuilder.append("<html>");

		stringBuilder.append("<head>");

		stringBuilder
				.append("<style> table,th,td { border:1px solid black; border-collapse:collapse; }"
						+ "th,td { padding:5px; }" + "</style>");

		stringBuilder.append("</head>");

		stringBuilder.append("<body>");

		stringBuilder.append("<form action='"+Util.PATH_REQUEST+"' method='post'>");

		for (final String atribute : atributeList) {
			stringBuilder.append(atribute + ": <input type=\"text\" name=\""
					+ atribute + "\"><br>");
		}

		stringBuilder.append("<input type=\"hidden\" name=\""+Util.PARAM_NAME+"\" value=\""+value+"\"/>");
		
		stringBuilder.append("<input type=\"submit\" value=\"Submeter\"/>");
		
		

		stringBuilder.append("</form>");

		stringBuilder.append("</body>");

		stringBuilder.append("</html>");

		return stringBuilder.toString();
	}

	private String getPageUserAnonymousList(final List<String> atributeList,
			final List<Repair> repeairList) {

		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("<table>");
		stringBuilder.append("<tr>");

		for (final String atribute : atributeList) {
			stringBuilder.append("<th>" + atribute + "</th>");
		}

		stringBuilder.append("</tr>");
		stringBuilder.append("<tr>");

		if (repeairList != null){
				
			for (final Repair repair : repeairList) {
				
				stringBuilder.append("<th>" + repair.getDescription() + "</th>");
				stringBuilder.append("<th>" + repair.getOpeningDate() + "</th>");
				
				if (repair instanceof LightingRepeair) {
					stringBuilder.append("<th>" + ((LightingRepeair) repair).getLightingType() + "</th>");
				} else if (repair instanceof ArborizationRepair) {
					stringBuilder.append("<th>" + ((ArborizationRepair) repair).getTreeType() + "</th>");
				}
				
				stringBuilder.append("<th>" + repair.getStatus().getName() + "</th>");
			}
		
		}

		stringBuilder.append("</tr>");

		stringBuilder.append("</table>");

		return stringBuilder.toString();
	}

	private String getPageUserLoggedList(final List<String> atributeList,
			final List<Repair> repeairList) {

		final StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("<table>");
		stringBuilder.append("<tr>");

		for (final String atribute : atributeList) {
			stringBuilder.append("<th>" + atribute + "</th>");
		}

		stringBuilder.append("</tr>");
		stringBuilder.append("<tr>");

		if (repeairList != null){
		
			for (final Repair repair : repeairList) {
				
				stringBuilder.append("<th>" + repair.getDescription() + "</th>");
				stringBuilder.append("<th>" + repair.getOpeningDate() + "</th>");
				
				
				GeoMapData geoMapData = new GeoMapData(7, new Integer[] { 1, 2 }, false);
				String url;
				try {
					url = serviceManager.getStaticMapURL(geoMapData);
				} catch (StaticMapException e) {
					url = "http://www.google.com.br";
					e.printStackTrace();
				}
				
				
				stringBuilder.append("<th> <a href=\""+ url +"\">Visualizar</a> </th>");
				
				if (repair instanceof LightingRepeair) {
					stringBuilder.append("<th>" + ((LightingRepeair) repair).getLightingType() + "</th>");
				} else if (repair instanceof ArborizationRepair) {
					stringBuilder.append("<th>" + ((ArborizationRepair) repair).getTreeType() + "</th>");
				}
				
				stringBuilder.append("<th>" + repair.getStatus().getName() + "<a href=\"#\">Alterar</a>" + "</th>");
			}
		
		}

		stringBuilder.append("</tr>");

		stringBuilder.append("</table>");

		return stringBuilder.toString();
	}
}
