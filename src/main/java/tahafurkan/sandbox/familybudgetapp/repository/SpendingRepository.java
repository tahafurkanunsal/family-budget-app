package tahafurkan.sandbox.familybudgetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tahafurkan.sandbox.familybudgetapp.model.Spending;



import java.util.List;

public interface SpendingRepository extends JpaRepository<Spending, Integer> {

    List<Spending> findByUserId(int id);

}
