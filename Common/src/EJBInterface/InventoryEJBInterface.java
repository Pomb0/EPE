package EJBInterface;

import DataBean.ItemBean;

import javax.ejb.Remote;
import javax.persistence.Column;

@Remote
public interface InventoryEJBInterface {
    boolean addItem(ItemBean product);
}
