package marcos.filho.compassRESTfulAPI.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student_tb")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;
    private String name;

    public Student(Long idStudent, String name){
        this.idStudent = idStudent;
        this.name = name;
    }
    @JsonBackReference
    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    private Set<Classroom> classrooms = new HashSet<>();

}
