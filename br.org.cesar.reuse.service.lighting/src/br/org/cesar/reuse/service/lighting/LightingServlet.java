package br.org.cesar.reuse.service.lighting;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.cesar.reuse.commons.model.User;

public class LightingServlet extends HttpServlet {

	private static final long serialVersionUID = 8901050865850456554L;

	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		super.doGet(request, response);

		response.getWriter().write("</br></br></br></br></br>");
	}

	private String getPageList(final List<String> atributeList,
			final List<LightingRepeair> lightingRepeairList, final User user) {
		
		final StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("<table>");

		if (user == null) {
			stringBuilder.append("<tr>");

			for (final String atribute : atributeList) {
				stringBuilder.append("<th>" + atribute + "</th>");
			}

			stringBuilder.append("</tr>");
			stringBuilder.append("<tr>");

			for (final LightingRepeair lightingRepeair : lightingRepeairList) {
				stringBuilder.append("<th>" + lightingRepeair.getDescription() + "</th>");
				stringBuilder.append("<th>" + lightingRepeair.getOpeningDate() + "</th>");
				stringBuilder.append("<th> <a href=\"url\">Visualizar</a> </th>");
				stringBuilder.append("<th>" + lightingRepeair.getLightingType() + "</th>");
				stringBuilder.append("<th>" + lightingRepeair.getStatus().getName() + "</th>");
			}
			
			stringBuilder.append("</tr>");
		
		} else {

			stringBuilder.append("<tr>");

			for (final String atribute : atributeList) {
				stringBuilder.append("<th>" + atribute + "</th>");
			}

			stringBuilder.append("</tr>");
			stringBuilder.append("<tr>");

			for (final LightingRepeair lightingRepeair : lightingRepeairList) {
				stringBuilder.append("<th>" + lightingRepeair.getDescription() + "</th>");
				stringBuilder.append("<th>" + lightingRepeair.getOpeningDate() + "</th>");
				stringBuilder.append("<th> <a href=\"url\">Visualizar</a> </th>");
				stringBuilder.append("<th>" + lightingRepeair.getLightingType() + "</th>");
				stringBuilder.append("<th>" + lightingRepeair.getStatus().getName() + "<a href=\"url\">Alterar</a>"+ "</th>");
			}
			
			stringBuilder.append("</tr>");

		}

		stringBuilder.append("</table>");
		
		return stringBuilder.toString();
	}
}