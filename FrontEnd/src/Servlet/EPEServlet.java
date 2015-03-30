package Servlet;

import EJBInterface.UserEJBInterface;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Jaime on 30/03/2015.
 *
 * Application specific Servlet abstraction.
 * Takes care of session and notifications.
 */
public abstract class EPEServlet extends HttpServlet{
	@EJB
	private UserEJBInterface userEJB;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	//Stuff to be overridden.
	protected abstract void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

	protected abstract void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
