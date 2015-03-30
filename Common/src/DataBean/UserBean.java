package DataBean;

import java.io.Serializable;

/**
 * Created by Jaime on 30/03/2015.
 *
 */
public class UserBean implements Serializable{
	private int id;
	private String username;
	private String password;

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
