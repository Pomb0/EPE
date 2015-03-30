package DataBean;

import java.io.Serializable;

public class ItemBean implements Serializable{
    enum PlantType{
        SHRUB(1), TREE(2), SEED(3);
        private int value;
        private PlantType(int value) {this.value = value;}
        public int getValue(){return value;}
    }

    private int id;
    private PlantType planta;
    private int stock;
    private double price;
    private String description;
    private String productCode;

    public ItemBean(int id, PlantType planta , int stock , double price, String description , String productCode){
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
