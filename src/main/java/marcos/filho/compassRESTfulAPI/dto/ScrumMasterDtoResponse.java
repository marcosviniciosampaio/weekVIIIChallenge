package marcos.filho.compassRESTfulAPI.dto;

import marcos.filho.compassRESTfulAPI.entity.ScrumMaster;

public class ScrumMasterDtoResponse {
    private Long id;
    private String name;

    public ScrumMasterDtoResponse(){}

    public ScrumMasterDtoResponse(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
