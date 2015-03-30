package Beans;

import EJBInterface.UserBeanInterface;
import JPA.Entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UserBeanEJB implements UserBeanInterface {
    @PersistenceContext(name="jpaUnit")
    EntityManager entityManager;

    //Creates user, returns enum UserCreationResult
    @Override
    public UserCreationResult createUser(String username, String password) {
        try {
            UserEntity newUser = new UserEntity();
            newUser
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
        return false;
    }
}
