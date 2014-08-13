package br.org.cesar.reuse.service.arborization;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.cesar.reuse.commons.model.User;

public class ArborizationServlet extends HttpServlet {

	private static final long serialVersionUID = 8744103144769150540L;

	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		super.doGet(request, response);

		response.getWriter().write("</br></br></br></br></br>");
	}

	private String getPageList(final List<String> atributeList,
			final List<ArborizationRepair> arborizationRepairList, final User user) {
		
		final StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("<table>");

		if (user == null) {
			stringBuilder.append("<tr>");

			for (final String atribute : atributeList) {
				stringBuilder.append("<th>" + atribute + "</th>");
			}

			stringBuilder.append("</tr>");
			stringBuilder.append("<tr>");

			for (final ArborizationRepair arborizationRepair : arborizationRepairList) {
				stringBuilder.append("<th>" + arborizationRepair.getDescription() + "</th>");
				stringBuilder.append("<th>" + arborizationRepair.getOpeningDate() + "</th>");
				stringBuilder.append("<th> <a href=\"url\">Visualizar</a> </th>");
				stringBuilder.append("<th>" + arborizationRepair.getTreeType() + "</th>");
				stringBuilder.append("<th>" + arborizationRepair.getStatus().getName() + "</th>");
			}
			
			stringBuilder.append("</tr>");
		
		} else {

			stringBuilder.append("<tr>");

			for (final String atribute : atributeList) {
				stringBuilder.append("<th>" + atribute + "</th>");
			}

			stringBuilder.append("</tr>");
			stringBuilder.append("<tr>");

			for (final ArborizationRepair arborizationRepair : arborizationRepairList) {
				stringBuilder.append("<th>" + arborizationRepair.getDescription() + "</th>");
				stringBuilder.append("<th>" + arborizationRepair.getOpeningDate() + "</th>");
				stringBuilder.append("<th> <a href=\"url\">Visualizar</a> </th>");
				stringBuilder.append("<th>" + arborizationRepair.getTreeType() + "</th>");
				stringBuilder.append("<th>" + arborizationRepair.getStatus().getName() + "<a href=\"url\">Alterar</a>"+ "</th>");
			}
			
			stringBuilder.append("</tr>");

		}

		stringBuilder.append("</table>");
		
		return stringBuilder.toString();
	}
}
