package tahafurkan.sandbox.familybudgetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tahafurkan.sandbox.familybudgetapp.model.Spending;

public interface SpendingRepository extends JpaRepository<Spending , Integer> {
}
