package marcos.filho.compassRESTfulAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentDtoResponse {
    private Long id;

    private String name;

    public StudentDtoResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
