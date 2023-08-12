package marcos.filho.compassRESTfulAPI.repository;

import marcos.filho.compassRESTfulAPI.entity.ScrumMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrumMasterRepository extends JpaRepository<ScrumMaster, Long> {
}
