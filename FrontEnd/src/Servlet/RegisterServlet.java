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
 */
public class RegisterServlet extends EPEServlet {

	@Override
	protected void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		switch( userEJB.createUser(username, password) ){
			case OK:
				break;
			case DUPLICATE_USER:
				break;
			case UNKNOWN:
				break;
		}

		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
