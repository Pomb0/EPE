package JPA.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProductEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private PlantsEntity planta;

	@Column(nullable = false)
	private int stock;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String productCode;


	public Integer getId() {
		return id;
	}

	public PlantsEntity getPlanta() {
		return planta;
	}

	public int getStock() {
		return stock;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getProductCode() {
		return productCode;
	}

	public ProductEntity setPlanta(final PlantsEntity planta) {
		this.planta = planta;
		return this;
	}

	public ProductEntity setStock(final int stock) {
		this.stock = stock;
		return this;
	}

	public ProductEntity setPrice(final double price) {
		this.price = price;
		return this;
	}

	public ProductEntity setDescription(final String description) {
		this.description = description;
		return this;
	}

	public ProductEntity setProductCode(final String productCode) {
		this.productCode = productCode;
		return this;
	}


}
