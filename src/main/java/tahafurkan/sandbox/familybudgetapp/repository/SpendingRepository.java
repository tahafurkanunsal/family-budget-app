package tahafurkan.sandbox.familybudgetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tahafurkan.sandbox.familybudgetapp.model.Spending;

import java.util.List;

public interface SpendingRepository extends JpaRepository<Spending, Integer> {

    List<Spending> findByUserId(int id);

    @Query("SELECT u FROM Spending u WHERE u.price = (SELECT MAX(u.price) FROM Spending u)")
    List<Spending> findMostSpendingUser();
}
