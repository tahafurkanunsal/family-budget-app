package tahafurkan.sandbox.familybudgetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tahafurkan.sandbox.familybudgetapp.model.Spending;
import tahafurkan.sandbox.familybudgetapp.model.User;

import java.util.Date;
import java.util.List;

public interface SpendingRepository extends JpaRepository<Spending, Integer> {

    List<Spending> findByUserId(int id);

    @Query("SELECT s  FROM Spending s WHERE s.date BETWEEN :startDate AND :endDate")
    List<Spending> findSpendingsAtBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT s.user, SUM(s.price) as totalSpend FROM Spending s GROUP BY s.user ORDER BY totalSpend DESC")
    List<User> findUsersWithHighestTotalSpend();

    @Query("Select s.user , SUM(s.price) as totalSpend FROM Spending s WHERE s.date BETWEEN :startDate and :endDate GROUP BY s.user ORDER BY totalSpend DESC")
    List<User> findMostSpendingByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT s FROM Spending s WHERE s.price = (SELECT MAX(s.price) FROM Spending s WHERE s.date BETWEEN:startDate and :endDate)")
    List<Spending> findMostSpendingDetailsByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
