package Servlet;

import EJBInterface.UserEJBInterface;
import Servlet.Notifications.NotificationType;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by  Jaime on 27/03/2015.
 *
 */

public class IndexServlet extends EPEServlet {
	@EJB
	private UserEJBInterface userEJB;

	@Override
	protected void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if(!isLogged(session)){resp.sendRedirect("session"); return;} //Refuse Un-logged

		addNotification(req.getSession(), NotificationType.ERROR, "THIS IS A TEST ERROR");
		addNotification(req.getSession(), NotificationType.INFO, "THIS IS A TEST INFORMATION " + getUserBean(session).getUsername());

		showNotifications(req);
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/index.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
