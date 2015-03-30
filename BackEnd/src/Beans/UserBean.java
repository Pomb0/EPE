package Beans;

import EJBInterface.UserBeanInterface;

import javax.ejb.Stateless;


@Stateless
public class UserBean implements UserBeanInterface {

	@Override
	public String test() {
		return "It really is working :D";
	}

	@Override
	public boolean createUser(String username, String password) {
		return false;
	}

	@Override
	public boolean authenticate(String username, String password) {
		return false;
	}
}
