package JPA.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
public class OrderEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private ClientEntity client;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<ProductEntity> productToOrder;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private Timestamp date;

	@Column(nullable = false)
	private Boolean shipped;

	@Column(nullable = false)
	private double totalCost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
