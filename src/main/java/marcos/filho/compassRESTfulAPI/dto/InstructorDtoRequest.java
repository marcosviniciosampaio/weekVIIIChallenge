package marcos.filho.compassRESTfulAPI.dto;

public class InstructorDtoRequest {
    private String name;
    private String lastname;
    private String email;
    private String role;

    public InstructorDtoRequest(){}

    public InstructorDtoRequest(String name, String lastname, String email, String role) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
