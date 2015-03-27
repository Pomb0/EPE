package EJBInterface;

import javax.ejb.Remote;

/**
 * Created by Jaime on 27/03/2015.
 *
 */

@Remote
public interface UserBeanInterface {
	public String test();
}
