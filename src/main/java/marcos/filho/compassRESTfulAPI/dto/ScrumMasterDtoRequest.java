package marcos.filho.compassRESTfulAPI.dto;

public class ScrumMasterDtoRequest {
    private String name;

    public ScrumMasterDtoRequest(){}
    public ScrumMasterDtoRequest(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
