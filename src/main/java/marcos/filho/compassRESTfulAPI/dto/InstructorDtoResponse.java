package marcos.filho.compassRESTfulAPI.dto;

import org.springframework.data.relational.core.sql.In;

public class InstructorDtoResponse {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String role;

    public InstructorDtoResponse(){}

    public InstructorDtoResponse(Long id, String name, String lastname, String email, String role){
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
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

    public void setRole(String function) {
        this.role = role;
    }
}
