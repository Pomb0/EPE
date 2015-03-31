package EJBInterface;

import DataBean.ClientBean;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ClientEJBInterface {
    List<ClientBean> getInventory();
    ClientBean getClient(int id);
}
