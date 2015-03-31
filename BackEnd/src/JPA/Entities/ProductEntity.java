package JPA.Entities;

import DataBean.ItemBean;
import DataBean.PlantTypeBean;

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

	public ItemBean getBean(){
		PlantTypeBean plant = new PlantTypeBean()
				.setType(this.getPlanta().getType())
				.setId(this.getPlanta().getId());

		ItemBean newItem= new ItemBean()
				.setDescription(this.getDescription())
				.setId(this.getId())
				.setPlanta(plant)
				.setStock(this.getStock())
				.setProductCode(this.getProductCode())
				.setPrice(this.getPrice());

		return newItem;
	}
	public ProductEntity toEntity(ItemBean bean, PlantsEntity plant){
		this.setDescription(bean.getDescription());
		this.setPrice(bean.getPrice());
		this.setProductCode(bean.getProductCode());
		this.setStock(bean.getStock());
		this.setPlanta(plant);

		return this;
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
