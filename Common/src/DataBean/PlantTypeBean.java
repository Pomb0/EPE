package DataBean;

public class PlantTypeBean {
    private int id;
    private String type;

    public PlantTypeBean(int id , String type){
        this.id = id;
        this.type = type;
    }

    public PlantTypeBean(){

    }

    public String getType() {
        return type;
    }

    public int getId() {

        return id;
    }

    public PlantTypeBean setId(final int id) {
        this.id = id;
        return this;
    }

    public PlantTypeBean setType(final String type) {
        this.type = type;
        return this;
    }


}
