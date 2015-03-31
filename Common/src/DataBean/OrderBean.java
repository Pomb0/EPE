package DataBean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Jaime on 30/03/2015.
 *
 */
public class OrderBean implements Serializable{
    private int id;
    private ClientBean client;
    private List<ItemBean> itemList;
    private String username;
    private Timestamp dateOrder;
    private Timestamp dateShipped;
    private Boolean shipped;
    private double totalCost;

    public OrderBean(){
        this.totalCost = 0;

        java.util.Date date= new java.util.Date();
        this.dateOrder = new Timestamp(date.getTime());
    }

    public void additem(ItemBean newItem){
        this.itemList.add(newItem);
        totalCost += newItem.getPrice();
    }

    public void calculateTotal(){
        this.totalCost = 0;
        for(ItemBean i : this.itemList) this.totalCost+=i.getPrice();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient(ClientBean client) {
        this.client = client;
    }

    public void setItemList(List<ItemBean> itemList) {
        this.itemList = itemList;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setShipped(Boolean shipped) {
        this.shipped = shipped;
        java.util.Date date= new java.util.Date();

        if(shipped)
            this.dateShipped = new Timestamp(date.getTime());
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getId() {

        return id;
    }

    public ClientBean getClient() {
        return client;
    }

    public List<ItemBean> getItemList() {
        return itemList;
    }

    public String getUsername() {
        return username;
    }

    public void setDateOrder(Timestamp dateOrder) {
        this.dateOrder = dateOrder;
    }

    public void setDateShipped(Timestamp dateShipped) {
        this.dateShipped = dateShipped;
    }

    public Timestamp getDateOrder() {
        return dateOrder;
    }

    public Timestamp getDateShipped() {
        return dateShipped;
    }

    public Boolean getShipped() {
        return shipped;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
