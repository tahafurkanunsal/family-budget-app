package tahafurkan.sandbox.familybudgetapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tahafurkan.sandbox.familybudgetapp.exception.NoSuchUserExistsException;
import tahafurkan.sandbox.familybudgetapp.model.Spending;
import tahafurkan.sandbox.familybudgetapp.model.User;
import tahafurkan.sandbox.familybudgetapp.model.dto.SpendingRequestDto;
import tahafurkan.sandbox.familybudgetapp.repository.SpendingRepository;
import tahafurkan.sandbox.familybudgetapp.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SpendingServiceImpl implements SpendingService {

    @Autowired
    SpendingRepository spendingRepository;

    private static final Logger logger = LoggerFactory.getLogger(SpendingServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Spending> getAll() {
        logger.info("Find all spendings");
        return spendingRepository.findAll();
    }

    @Override
    public List<Spending> getSpendingsByDate(Date startDate, Date endDate) {
        logger.info("spendings by date : {} , {}" , startDate , endDate);
        return spendingRepository.findSpendingsAtBetween(startDate, endDate);
    }

    @Override
    public Spending create(SpendingRequestDto spendingDto) {
        Spending spending = new Spending();

        spending.setDate(spendingDto.getDate());
        spending.setPrice(spendingDto.getPrice());
        spending.setType(spendingDto.getType());
        spending.setBillingType(spendingDto.getBillingType());
        spending.setDetails(spendingDto.getDetails());

        Optional<User> userOptional = userRepository.findById(spendingDto.getUserId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            spending.setUser(user);
        } else {
            throw new NoSuchUserExistsException("NO USER PRESENT WITH ID =" + spendingDto.getUserId());
        }
        logger.info("Created new spendings by user id : {}" , spending.getUser().getId());
        return spendingRepository.save(spending);
    }
}
