package tahafurkan.sandbox.familybudgetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tahafurkan.sandbox.familybudgetapp.enums.SpendingTypes;
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

    @Query("Select s.user , SUM(s.price) as totalSpend FROM Spending s WHERE s.date BETWEEN :startDate and :endDate " +
            "GROUP BY s.user ORDER BY totalSpend DESC")
    List<User> findMostSpendingByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("SELECT s FROM Spending s WHERE s.date BETWEEN :startDate and :endDate " +
            "AND s.user = (SELECT s2.user FROM Spending s2 WHERE s2.date BETWEEN :startDate and :endDate " +
            "GROUP BY s2.user ORDER BY SUM(s2.price)DESC LIMIT 1)")
    List<Spending> findMostSpendingDetailsByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("Select s.user , SUM(s.price) AS totalSpend FROM Spending s WHERE s.date BETWEEN :startDate and :endDate " +
            "And s.type= :type GROUP BY s.user ORDER BY totalSpend DESC")
    List<User> findMostGrocerySpendingByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate,
                                             @Param("type") SpendingTypes type);

    @Query("Select s.user , SUM(s.price) AS totalSpend From Spending s GROUP BY s.user ORDER BY totalSpend DESC")
    List<User> sortUsersBySpendingSize();

}
