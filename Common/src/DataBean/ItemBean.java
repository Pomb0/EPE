package DataBean;

import java.io.Serializable;

public class ItemBean implements Serializable{
    private int id;
    private PlantTypeBean planta;
    private int stock;
    private double price;
    private String description;
    private String productCode;

    public ItemBean(int id, PlantTypeBean planta , int stock , double price, String description , String productCode){
        this.id = id;
        this.planta = planta;
        this.stock = stock;
        this.price = price;
        this.description = description;
        this.productCode = productCode;
    }

    public ItemBean(){

    }
}
