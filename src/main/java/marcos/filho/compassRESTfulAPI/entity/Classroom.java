package marcos.filho.compassRESTfulAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "class_tb")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClass;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "student_tb",
            joinColumns = @JoinColumn(name = "idClass"),
            inverseJoinColumns = @JoinColumn(name = "idStudent")
    )
    private List<Student> students = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClassStatus status;
    public enum ClassStatus{
        WAITING,
        STARTED,
        FINISHED
    }
}
