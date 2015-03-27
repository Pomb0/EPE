import EJBInterface.UserBeanInterface;

import javax.ejb.Stateless;


/**
 * Created by Jaime on 27/03/2015.
 *
 */

@Stateless
public class UserBean implements UserBeanInterface {

	@Override
	public String test() {
		return "This is seriously working bitch >:D";
	}
}
