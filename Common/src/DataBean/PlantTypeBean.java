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

    private int getId(){
        return this.id;
    }

    private String getType(){
        return this.type;
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
