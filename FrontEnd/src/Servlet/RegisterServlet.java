package Servlet;

import EJBInterface.UserEJBInterface;
import Servlet.Notifications.NotificationType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Jaime on 31/03/2015.
 *
 */
public class RegisterServlet extends EPEServlet {

	@Override
	protected void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String vpassword = req.getParameter("vpassword");

		if(!password.equals(password)) addNotification(session, NotificationType.ERROR, "Passwords do not match.");

		if( username!=null && password!=null && vpassword!=null && password.equals(password)) {
			UserEJBInterface.UserCreationResult result = userEJB.createUser(username, password);
			switch (result) {
				case DUPLICATE_USER:
					addNotification(session, NotificationType.ERROR, "The username, " + username + " is already taken.");
					break;
				case UNKNOWN:
					addNotification(session, NotificationType.ERROR, "An error occurred, try again later.");
					break;
				case OK:
					addNotification(session, NotificationType.INFO, "Account created with success.");
					resp.sendRedirect("index");
					return;
			}
		}

		showNotifications(req);
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		rd.forward(req, resp);
	}
}
