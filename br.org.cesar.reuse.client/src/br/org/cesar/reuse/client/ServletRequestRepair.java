package br.org.cesar.reuse.client;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.cesar.reuse.commons.model.ArborizationRepair;
import br.org.cesar.reuse.commons.model.LightingRepeair;
import br.org.cesar.reuse.commons.model.Location;
import br.org.cesar.reuse.commons.model.RepairStatus;
import br.org.cesar.reuse.commons.service.IRepair;
import br.org.cesar.reuse.service.ServiceManager;
import br.org.cesar.reuse.service.arborization.ArborizationService;
import br.org.cesar.reuse.service.lighting.LightingService;

public class ServletRequestRepair extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

	}

	@Override
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {

		final ServiceManager serviceManager = Activator.getServiceManager();

		final String value = request.getParameter(Util.PARAM_NAME);

		if (value != null) {

			final IRepair serviceRepair = serviceManager.getService(value);

			boolean success = false;

			if (serviceRepair instanceof LightingService) {

				// get fields from form
				final LightingRepeair repair = new LightingRepeair();
				repair.setDescription("Teste Light");
				repair.setId(System.currentTimeMillis());
				repair.setLocation(new Location(-8.058152, -34.871964));
				repair.setOpeningDate(new Date());
				repair.setStatus(RepairStatus.OPEN);
				repair.setLightingType("Poste");

				success = serviceRepair.requestRepair(repair);

			} else if (serviceRepair instanceof ArborizationService) {

				// get fields from form
				final ArborizationRepair repair = new ArborizationRepair();
				repair.setDescription("Teste");
				repair.setId(System.currentTimeMillis());
				repair.setLocation(new Location(-8.058152, -34.871964));
				repair.setOpeningDate(new Date());
				repair.setStatus(RepairStatus.OPEN);
				repair.setTreeType("Arvore Pau Brasil");

				success = serviceRepair.requestRepair(repair);
			}

			if (success) {
				response.getWriter().write(
						"<html><body> Servico Requisitado com Sucesso! <br> ");
				response.getWriter().write("</body></html>");
			} else {
				response.getWriter().write(
						"<html><body> Falha ao requisitar o serviço! <br> ");
				response.getWriter().write("</body></html>");
			}
		}
	}

}
