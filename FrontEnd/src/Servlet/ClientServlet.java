package Servlet;

import DataBean.ClientBean;
import EJBInterface.ClientEJBInterface;
import Servlet.Notifications.NotificationType;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Jaime on 01/04/2015.
 *
 * Lists clients
 */
public class ClientServlet extends EPEServlet{
	@EJB
	ClientEJBInterface clientEJB;

	@Override
	protected void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		RequestDispatcher rd;

		if(req.getParameterMap().containsKey("add")){ //Add a new One
			rd = req.getRequestDispatcher("WEB-INF/jsp/client/add.jsp");
		}else if(req.getParameterMap().containsKey("id")){ //View or edit
			try{
				int id = Integer.parseInt(req.getParameter("id"));
				ClientBean clientBean = clientEJB.getClient(id);
				if(clientBean!=null) {
					req.setAttribute("client", clientBean);
					rd = req.getRequestDispatcher("WEB-INF/jsp/client/view.jsp");
				}else{
					addNotification(session, NotificationType.ERROR, "The client you tried to view does not exist.");
					resp.sendRedirect("client");
					return;
				}
			}catch(Exception e){
				addNotification(session, NotificationType.ERROR, "The client you tried to view does not exist.");
				resp.sendRedirect("client");
				return;
			}

		}else{  //Just list'em
			List<ClientBean> clientList = clientEJB.getInventory();
			req.setAttribute("clientList", clientList);
			rd = req.getRequestDispatcher("WEB-INF/jsp/client/list.jsp");
		}

		showNotifications(req);
		rd.forward(req, resp);
	}

	@Override
	protected void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if( req.getParameterMap().containsKey("save") ){
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String address = req.getParameter("address");
			String phone = req.getParameter("phone");

			if(firstName!=null && lastName!=null && address!=null && phone!=null){
				boolean result = clientEJB.addClient(new ClientBean()
						.setFirstName(firstName)
						.setLastName(lastName)
						.setAddress(address)
						.setPhoneNumber(phone)
				);
				if(result) addNotification(session, NotificationType.INFO, "Client Added.");
				else addNotification(session, NotificationType.ERROR, "Failed to add client.");
			}
		}
		resp.sendRedirect("client");
	}
}
