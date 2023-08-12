package marcos.filho.compassRESTfulAPI.repository;

import marcos.filho.compassRESTfulAPI.entity.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator, Long> {
}
