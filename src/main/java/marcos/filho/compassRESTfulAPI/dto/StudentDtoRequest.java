package marcos.filho.compassRESTfulAPI.dto;

public class StudentDtoRequest{
    private String name;
    public StudentDtoRequest(){}

    public StudentDtoRequest(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
