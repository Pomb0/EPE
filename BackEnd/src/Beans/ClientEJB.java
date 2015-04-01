package Beans;

import DataBean.ClientBean;
import EJBInterface.ClientEJBInterface;
import JPA.Entities.ClientEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class ClientEJB implements ClientEJBInterface {
	@PersistenceContext(name = "jpaUnit")
	EntityManager entityManager;

	@Override
	public List<ClientBean> getInventory() {
		List<ClientBean> clientBeans = new LinkedList<>();

		try {
			Query query = entityManager.createQuery("FROM ClientEntity");
			List<ClientEntity> list = (List<ClientEntity>) query.getResultList();

			if (list != null) {
				for (ClientEntity i : list) {
					clientBeans.add(i.toBean());
				}
			}

			return clientBeans;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ClientBean getClient(int id) {
		return getClientEntity(id).toBean();
	}

	public ClientEntity getClientEntity(int id) {
		try {
			Query query = entityManager.createQuery("FROM ClientEntity u WHERE u.id = :t");
			query.setParameter("t", id);

			List<ClientEntity> result = (List<ClientEntity>) query.getResultList();

			if (result != null && !result.isEmpty()) {
				return result.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
