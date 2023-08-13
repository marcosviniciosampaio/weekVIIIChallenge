package marcos.filho.compassRESTfulAPI.dto;

public class SquadDtoRequest {
    private String name;

    public SquadDtoRequest(){

    }

    public SquadDtoRequest(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
