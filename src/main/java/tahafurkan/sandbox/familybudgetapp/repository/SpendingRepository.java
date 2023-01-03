package tahafurkan.sandbox.familybudgetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tahafurkan.sandbox.familybudgetapp.model.Spending;

import java.util.Date;
import java.util.List;

public interface SpendingRepository extends JpaRepository<Spending, Integer> {

    List<Spending> findByUserId(int id);

    @Query("SELECT s  FROM Spending s WHERE s.date BETWEEN :startDate AND :endDate")
    List<Spending> findSpendingsAtBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
