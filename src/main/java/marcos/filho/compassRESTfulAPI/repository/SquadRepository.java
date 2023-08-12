package marcos.filho.compassRESTfulAPI.repository;


import jakarta.persistence.Entity;
import marcos.filho.compassRESTfulAPI.entity.Squad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadRepository extends JpaRepository<Squad, Long> {
}
