package marcos.filho.compassRESTfulAPI.repository;

import marcos.filho.compassRESTfulAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
