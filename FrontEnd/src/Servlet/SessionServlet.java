package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Jaime on 31/03/2015.
 *
 * Takes care of logins and logouts
 */
public class SessionServlet extends EPEServlet {
	@Override
	protected void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if(req.getParameterMap().containsKey("logout")){  //Logout

		}


		showNotifications(req);
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
	}
}
