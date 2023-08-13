package marcos.filho.compassRESTfulAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassroomDtoRequest {

    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
