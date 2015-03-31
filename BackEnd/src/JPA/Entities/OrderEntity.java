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

	public OrderEntity setDateOrdered(final Timestamp dateOrdered) {
		this.dateOrdered = dateOrdered;
		return this;
	}

	public OrderEntity setDateShipped(final Timestamp dateShipped) {
		this.dateShipped = dateShipped;
		return this;
	}

	@Column(nullable = false)
	private Timestamp dateOrdered;

	@Column(nullable = false)
	private Timestamp dateShipped;

	@Column(nullable = false)
	private Boolean shipped;

	@Column(nullable = false)
	private double totalCost;

	public OrderEntity setId(final int id) {
		this.id = id;
		return this;
	}

	public Timestamp getDateShipped() {
		return dateShipped;
	}

	public Boolean getShipped() {
		return shipped;
	}

	public Timestamp getDateOrdered() {

		return dateOrdered;
	}

	public int getId() {
		return id;
	}

	public ClientEntity getClient() {
		return client;
	}

	public Set<ProductEntity> getProductToOrder() {
		return productToOrder;
	}

	public String getUsername() {
		return username;
	}

	public Boolean isShipped() {
		return shipped;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public OrderEntity setClient(final ClientEntity client) {
		this.client = client;
		return this;
	}

	public OrderEntity setProductToOrder(final Set<ProductEntity> productToOrder) {
		this.productToOrder = productToOrder;
		return this;
	}

	public OrderEntity setUsername(final String username) {
		this.username = username;
		return this;
	}

	public OrderEntity setShipped(final Boolean shipped) {
		this.shipped = shipped;
		return this;
	}

	public OrderEntity setTotalCost(final double totalCost) {
		this.totalCost = totalCost;
		return this;
	}


}
