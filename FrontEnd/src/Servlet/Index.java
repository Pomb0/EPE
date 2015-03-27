package Servlet;

import EJBInterface.UserBeanInterface;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

/**
 * Created by  Jaime on 27/03/2015.
 *
 */

public class Index extends javax.servlet.http.HttpServlet {
	@EJB
	private UserBeanInterface userBean;

	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

	}

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException, IOException {
		request.setAttribute("test", userBean.test());
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
		rd.forward(request, response);
	}
}
