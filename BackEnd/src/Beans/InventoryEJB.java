package Beans;

import DataBean.ItemBean;
import DataBean.PlantTypeBean;
import EJBInterface.InventoryEJBInterface;
import JPA.Entities.PlantsEntity;
import JPA.Entities.ProductEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class InventoryEJB implements InventoryEJBInterface {
    @PersistenceContext(name="jpaUnit")
    EntityManager entityManager;

    @Override
    public boolean addItem(ItemBean product) {
        try {
            PlantsEntity plant = getPlant(product.getPlanta().getType());
            if(plant == null)
                return false;

            ProductEntity newProduct = new ProductEntity().toEntity(product, plant);
            entityManager.persist(newProduct);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ItemBean getItemBean(int id){ return getItemEntity(id).getBean(); }

    @Override
    public List<ItemBean> getInventory(){
        List<ItemBean> inventorybeans = null;

        try{
            Query query = entityManager.createQuery("FROM ProductEntity");
            List<ProductEntity> inventory = query.getResultList();

            for(ProductEntity i: inventory){
                inventorybeans.add(i.getBean());
            }

            return inventorybeans;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean modifyItem(int id, ItemBean newItem){
        PlantsEntity plant = getPlant(newItem.getPlanta().getType());
        if(plant == null)
            return false;

        ProductEntity itemToChange = getItemEntity(id);

        if(itemToChange == null)
            return false;
        else
            itemToChange.toEntity(newItem , plant);

        return true;
    }

    private PlantsEntity getPlant(String type) {
        try{
            Query query =  entityManager.createQuery("FROM PlantsEntity u WHERE u.type = :t") ;
            query.setParameter("t", type);
            return (PlantsEntity)query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public ProductEntity getItemEntity(int id){
        try {
            Query query =  entityManager.createQuery("FROM ProductEntity u WHERE u.id = :t") ;
            query.setParameter("t", id);
            ProductEntity product = (ProductEntity) query.getSingleResult();
            return product;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
