package Servlet;

import DataBean.ItemBean;
import DataBean.PlantTypeBean;
import EJBInterface.InventoryEJBInterface;
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
 * Created by Jaime on 31/03/2015.
 *
 * Implements item and inventory management functions
 * List, View, Add, Modify
 */
public class ItemServlet extends EPEServlet{
	@EJB
	InventoryEJBInterface inventoryEJB;

	@Override //Takes care off list and view
	protected void onGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//No paramteres defaults to listing all items.
		RequestDispatcher rd;
		if(req.getParameterMap().containsKey("add")) { //Add a new Item
			rd = req.getRequestDispatcher("WEB-INF/jsp/item/addItem.jsp");
		}else if (req.getParameterMap().containsKey("id")) {
			try {
				int id = Integer.parseInt(req.getParameter("id"));
				ItemBean item = inventoryEJB.getItemBean(id);
				if (item != null) {
					req.setAttribute("itemBean", item);
					rd = req.getRequestDispatcher("WEB-INF/jsp/item/viewEditItem.jsp");
				}else{
					addNotification(session, NotificationType.ERROR, "The item you tried to view, does not exist.");
					resp.sendRedirect("item");
					return;
				}
			}catch (Exception e){
				e.printStackTrace();
				addNotification(session, NotificationType.ERROR, "The item you tried to view, does not exist.");
				resp.sendRedirect("item");
				return;
			}
		}else{ //List Inventory
			//TODO segregate by type: shrub, etc...
			List<ItemBean> inventory = inventoryEJB.getInventory();
			req.setAttribute("inventory", inventory);
			rd = req.getRequestDispatcher("WEB-INF/jsp/inventory.jsp");
		}
		showNotifications(req);
		rd.forward(req, resp);
	}

	@Override //Handles additions and editions.
	protected void onPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if( req.getParameterMap().containsKey("save") ){
			String code = req.getParameter("code");
			String desc = req.getParameter("desc");
			String price = req.getParameter("price");
			String quantity = req.getParameter("quantity");
			String type = req.getParameter("type");

			if( code!=null && desc!=null && price!=null && quantity!=null && type!=null ){
				boolean result = inventoryEJB.addItem(new ItemBean()
						.setProductCode(code)
						.setDescription(desc)
						.setPrice(Double.parseDouble(price))
						.setStock(Integer.parseInt(quantity))
						.setPlantType(
								new PlantTypeBean().setType(type)
						)
				);
				if(result) addNotification(session, NotificationType.INFO, "Item added to inventory");
				else addNotification(session, NotificationType.ERROR, "Item could not be added to inventory");
			}
		}else if(req.getParameterMap().containsKey("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String desc = req.getParameter("desc");
			String price = req.getParameter("price");
			String quantity = req.getParameter("quantity");
			if( desc!=null && price!=null && quantity!=null ){
				inventoryEJB.modifyItem(id,
						inventoryEJB.getItemBean(id)
								.setDescription(desc)
								.setPrice(Double.parseDouble(price))
								.setStock(Integer.parseInt(quantity))
				);
				showNotifications(req);
				resp.sendRedirect("item?id=" + id);
				return;
			}
		}
		showNotifications(req);
		resp.sendRedirect("item");
	}
}
