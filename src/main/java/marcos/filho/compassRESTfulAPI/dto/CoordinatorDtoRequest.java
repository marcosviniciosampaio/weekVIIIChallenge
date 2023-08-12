package marcos.filho.compassRESTfulAPI.dto;

public class CoordinatorDtoRequest {
    private String name;

    public CoordinatorDtoRequest(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
