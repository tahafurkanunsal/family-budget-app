package tahafurkan.sandbox.familybudgetapp.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpendingRepositoryTest {

    @Autowired
    SpendingRepository spendingRepository;

    @Test
    @Sql({"/data.sql"})
    void findMostSpendingDetailsByDate_GivenDate_ReturnSpendingDetails() {
    }
    }
