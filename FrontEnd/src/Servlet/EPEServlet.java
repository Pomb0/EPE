package Servlet;

import EJBInterface.UserEJBInterface;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;

/**
 * Created by Jaime on 30/03/2015.
 *
 * Application specific Servlet abstraction.
 * Takes care of session and notifications.
 */
public abstract class EPEServlet extends HttpServlet{
	@EJB
	private UserEJBInterface userEJB;
}
