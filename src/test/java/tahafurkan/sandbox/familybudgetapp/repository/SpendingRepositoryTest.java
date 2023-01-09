package tahafurkan.sandbox.familybudgetapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import tahafurkan.sandbox.familybudgetapp.model.dto.UserSpendingDetails;

import java.util.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpendingRepositoryTest {

    @Autowired
    SpendingRepository spendingRepository;

    @Test
    @Sql({"/data.sql"})
    void findMostSpendingDetailsByDate_GivenDate_Return() {
        Date startDate = new Date(2001, 06, 1);
        Date endDate = new Date(2001, 06, 30);
        List<UserSpendingDetails> spendings = spendingRepository.findMostSpendingDetailsByDate(startDate , endDate);
        assertNotNull(spendings);
        assertEquals(1 , spendings.size());
    }
}
