package tahafurkan.sandbox.familybudgetapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import tahafurkan.sandbox.familybudgetapp.model.Spending;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class SpendingRepositoryTest {

    @Autowired
    SpendingRepository spendingRepository;

    @Test
    @Sql({"/data.sql"})
    void findMostSpendingDetailsByDate_GivenDate_ReturnSpendings() throws ParseException {
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2001-06-01");
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse("2001-06-30");
        List<Spending> spendings = spendingRepository.findMostSpendingDetailsByDate(startDate, endDate);
        assertEquals(5, spendings.size());
        assertEquals("tahafurkanunsal", spendings.get(0).getUser().getUsername());
    }
}