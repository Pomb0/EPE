package DataBean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Jaime on 30/03/2015.
 *
 */
public class OrderBean implements Serializable{
    private Integer id;
    private ClientBean client;
    private List<ItemBean> itemList;
    private UserBean user;
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

    public OrderBean setId(final Integer id) {
        this.id = id;
        return this;
    }

    public OrderBean setClient(final ClientBean client) {
        this.client = client;
        return this;
    }

    public OrderBean setItemList(final List<ItemBean> itemList) {
        this.itemList = itemList;
        return this;
    }

    public OrderBean setUser(final UserBean user) {
        this.user = user;
        return this;
    }

    public OrderBean setDateOrder(final Timestamp dateOrder) {
        this.dateOrder = dateOrder;
        return this;
    }

    public OrderBean setDateShipped(final Timestamp dateShipped) {
        this.dateShipped = dateShipped;
        return this;
    }

    public OrderBean setShipped(final Boolean shipped) {
        this.shipped = shipped;
        return this;
    }

    public OrderBean setTotalCost(final double totalCost) {
        this.totalCost = totalCost;
        return this;
    }


    public Integer getId() {

        return id;
    }

    public ClientBean getClient() {
        return client;
    }

    public List<ItemBean> getItemList() {
        return itemList;
    }

    public UserBean getUser() {
        return user;
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
