package JPA.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ClientEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String phoneNumber;


	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public ClientEntity setFirstName(final String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ClientEntity setLastName(final String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ClientEntity setAddress(final String address) {
		this.address = address;
		return this;
	}

	public ClientEntity setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}


}
