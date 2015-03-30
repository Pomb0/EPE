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

    private void setId(int id){
        this.id = id;
    }

    private void setType(String type){
        this.type = type;
    }


}
