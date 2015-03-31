package Beans;

import DataBean.OrderBean;
import DataBean.UserBean;
import EJBInterface.UserEJBInterface;
import JPA.Entities.OrderEntity;
import JPA.Entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;


@Stateless
public class UserEJB implements UserEJBInterface {
    @PersistenceContext(name="jpaUnit")
    EntityManager entityManager;

    public UserCreationResult createUser(String username, String password) {

    }

    //Creates user, returns enum UserCreationResult
    @Override
    public UserCreationResult createUser(String username, String password) {
        try {
            UserEntity newUser = new UserEntity()
                    .setUsername(username)
                    .setPassword(password);
            entityManager.persist(newUser);
        }catch (Exception e){
            while(e.getCause()!=null) e = (Exception) e.getCause();
            if(e.getMessage().contains("'" + username + "'")) return UserCreationResult.DUPLICATE_USER;
            return UserCreationResult.UNKNOWN;
        }
        return UserCreationResult.OK;
    }

    //Authenticates a user, returns true if authentication success, else, false.
    @Override
    public boolean authenticate(String username, String password) {
        return true;
    }

    @Override
    public UserBean getUser(int id) {
        try {
            Query query = entityManager.createQuery("FROM UserEntity o WHERE o.id = :t");
            query.setParameter("t", id);
            UserEntity user = (UserEntity) query.getSingleResult();

            UserBean Beanuser = user.toBean();

            return Beanuser;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
