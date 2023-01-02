package tahafurkan.sandbox.familybudgetapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tahafurkan.sandbox.familybudgetapp.exception.NoSuchUserExistsException;
import tahafurkan.sandbox.familybudgetapp.model.Spending;
import tahafurkan.sandbox.familybudgetapp.model.User;
import tahafurkan.sandbox.familybudgetapp.model.dto.SpendingDto;
import tahafurkan.sandbox.familybudgetapp.repository.SpendingRepository;
import tahafurkan.sandbox.familybudgetapp.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SpendingServiceImpl implements SpendingService {

    @Autowired
    SpendingRepository spendingRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Spending> getAll() {
        return spendingRepository.findAll();
    }


    @Override
    public Spending create(SpendingDto spendingDto) {
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

        return spendingRepository.save(spending);

    }
}
