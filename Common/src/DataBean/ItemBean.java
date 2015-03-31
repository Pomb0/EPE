package DataBean;

import java.io.Serializable;

public class ItemBean implements Serializable{
    private int id;
    private PlantTypeBean plantType;
    private int stock;
    private double price;
    private String description;
    private String productCode;

    public int getId() {
        return id;
    }

    public PlantTypeBean getPlantType() {
        return plantType;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getDescription() {
        return description;
    }

    public ItemBean setId(final int id) {
        this.id = id;
        return this;
    }

    public ItemBean setPlantType(final PlantTypeBean plantType) {
        this.plantType = plantType;
        return this;
    }

    public ItemBean setStock(final int stock) {
        this.stock = stock;
        return this;
    }

    public ItemBean setPrice(final double price) {
        this.price = price;
        return this;
    }

    public ItemBean setDescription(final String description) {
        this.description = description;
        return this;
    }

    public ItemBean setProductCode(final String productCode) {
        this.productCode = productCode;
        return this;
    }


}
