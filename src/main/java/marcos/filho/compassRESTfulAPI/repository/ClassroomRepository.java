package marcos.filho.compassRESTfulAPI.repository;

import marcos.filho.compassRESTfulAPI.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long>{
}
