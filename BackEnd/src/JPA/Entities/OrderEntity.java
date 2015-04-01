package JPA.Entities;

import DataBean.ItemBean;
import DataBean.OrderBean;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Entity
public class OrderEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private ClientEntity client;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<ProductEntity> productToOrder;

	@ManyToOne
	private UserEntity user;

	@Column(nullable = false)
	private Timestamp dateOrdered;

	@Column(nullable = true)
	private Timestamp dateShipped;

	@Column(nullable = false)
	private Boolean shipped;

	@Column(nullable = false)
	private double totalCost;

	public OrderEntity setDateOrdered(final Timestamp dateOrdered) {
		this.dateOrdered = dateOrdered;
		return this;
	}

	public OrderEntity setDateShipped(final Timestamp dateShipped) {
		this.dateShipped = dateShipped;
		return this;
	}

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

	public List<ProductEntity> getProductToOrder() {
		return productToOrder;
	}

	public UserEntity getUser() {
		return user;
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

	public OrderEntity setProductToOrder(final List<ProductEntity> productToOrder) {
		this.productToOrder = productToOrder;
		return this;
	}

	public OrderEntity setUsername(final UserEntity user) {
		this.user = user;
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


	public OrderEntity setUser(final UserEntity user) {
		this.user = user;
		return this;
	}

	public OrderBean toBean() {
		OrderBean temp = new OrderBean();

		temp.setClient(this.getClient().toBean())
				.setDateOrder(this.dateOrdered)
				.setDateShipped(this.getDateShipped())
				.setId(this.getId())
				.setTotalCost(this.totalCost)
				.setUser(this.getUser().toBean())
				.setShipped(this.getShipped())
				;

		List<ItemBean> var = new LinkedList<>();

		for(ProductEntity i : this.getProductToOrder()){
			var.add(i.getBean());
		}

		temp.setItemList(var);
		return temp;

	}

	public OrderEntity toEntity(OrderBean order) {
		this.setDateOrdered(order.getDateOrder())
				.setDateShipped(order.getDateShipped())
				.setShipped(order.getShipped())
				.setTotalCost(order.getTotalCost())
		;
		return this;

	}

}