package DataBean;

import java.io.Serializable;

public class PlantTypeBean implements Serializable {
    private Integer id;
    private String type;

    public PlantTypeBean(Integer id , String type){
        this.id = id;
        this.type = type;
    }

    public PlantTypeBean(){

    }

    public String getType() {
        return type;
    }

    public Integer getId() {

        return id;
    }

    public PlantTypeBean setId(final Integer id) {
        this.id = id;
        return this;
    }

    public PlantTypeBean setType(final String type) {
        this.type = type;
        return this;
    }


}
