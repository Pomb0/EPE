package Beans;

import DataBean.OrderBean;
import EJBInterface.OrderEJBInterface;
import JPA.Entities.OrderEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;


@Stateless
public class OrderEJB implements OrderEJBInterface {
    @PersistenceContext(name="jpaUnit")
    EntityManager entityManager;

    @Override
    public boolean addOrder(OrderBean order) {
        try {
            OrderEntity newOrder = new OrderEntity().toEntity(order);
            entityManager.persist(newOrder);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<OrderBean> getPendingList() {
        try {
            Query query = entityManager.createQuery("FROM OrderEntity o WHERE o.shipped = false");
            List<OrderEntity> resultList = (List<OrderEntity>)query.getResultList();

            List <OrderBean> finalList = new LinkedList<>();

            for(OrderEntity i : resultList){
                finalList.add(new OrderBean()
                        .setUser(i.getUser().toBean())
                        .setId(i.getId())
                        .setDateOrder(i.getDateOrdered())

                );
            }

            return finalList;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<OrderBean> getShippedList(){
        try {
            Query query = entityManager.createQuery("FROM OrderEntity o WHERE o.shipped = true");
            List<OrderEntity> resultList = (List<OrderEntity>)query.getResultList();

            List <OrderBean> finalList = new LinkedList<>();

            for(OrderEntity i : resultList){
                finalList.add(new OrderBean()
                                .setUser(i.getUser().toBean())
                                .setId(i.getId())
                                .setDateOrder(i.getDateOrdered())

                );
            }

            return finalList;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public OrderBean getOrder(int id){
        OrderEntity temp = getOrderEntity(id);

        if(temp != null)
                return temp.toBean();
        return null;


    }

    private OrderEntity getOrderEntity(int id) {
        try {
            Query query = entityManager.createQuery("FROM OrderEntity o WHERE o.id =:t ");
            query.setParameter("t", id);
            return (OrderEntity) query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean shipOrder(int id){
        OrderEntity itemToChange = getOrderEntity(id);

        if(itemToChange!=null)  itemToChange.setShipped(true);

        return true;
    }
}
