package JPA.Entities;

import javax.persistence.*;

@Entity
public class ClientEntity {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
