package Servlet;

import DataBean.ClientBean;
import DataBean.ItemBean;
import DataBean.OrderBean;
import DataBean.UserBean;
import EJBInterface.InventoryEJBInterface;
import EJBInterface.OrderEJBInterface;
import Servlet.Notifications.NotificationType;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Jaime on 01/04/2015.
 *
 * Provides interface and handles the creation of new orders.
 */
public class OrderServlet extends EPEServlet{
	@EJB
	OrderEJBInterface orderEJB;
	@EJB
	InventoryEJBInterface inventoryEJB;

	@Override
	protected void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(!isLogged(session)){resp.sendRedirect("session"); return;} //Refuse Un-logged

		if(req.getParameterMap().containsKey("buyerId")){  //add a new one
			req.setAttribute("buyerId", req.getParameter("buyerId"));
			req.setAttribute("inventory", inventoryEJB.getInventory());

			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/jsp/order/add.jsp");
			showNotifications(req);
			rd.forward(req, resp);
			return;
		}

		resp.sendRedirect("index");
	}

	@Override
	protected void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(!isLogged(session)){resp.sendRedirect("session"); return;} //Refuse Un-logged

		if(req.getParameterMap().containsKey("save")){

			Integer id = Integer.parseInt(req.getParameter("buyerId"));
			String productIdList[] = req.getParameterValues("productId");
			String productUnits[] = req.getParameterValues("units");

			if( productIdList!=null && productUnits!=null) {
				OrderBean orderBean = new OrderBean()
						.setShipped(false)
						.setDateOrder(new Timestamp(new Date().getTime()))
						.setClient(new ClientBean().setId(id))
						.setUser(new UserBean().setId(getUserId(session)));

				int i;
				for (i = 0; i < productIdList.length; i++) {
					if( Integer.parseInt(productUnits[i]) > 0 ) {
						orderBean.additem(
								new ItemBean()
										.setId(Integer.parseInt(productIdList[i]))
						);
					}
				}

				boolean result = orderEJB.addOrder(orderBean);

				addNotification(session, NotificationType.INFO, "Order created.");
			}

		}
		resp.sendRedirect("order");
	}
}
