package tahafurkan.sandbox.familybudgetapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tahafurkan.sandbox.familybudgetapp.model.Spending;
import tahafurkan.sandbox.familybudgetapp.repository.SpendingRepository;

import java.util.List;

@Service
public class SpendingServiceImpl implements SpendingService {

    @Autowired
    SpendingRepository spendingRepository;

    @Override
    public List<Spending> getAll() {
        return spendingRepository.findAll();
    }

    @Override
    public Spending create(Spending spending) {
        return spendingRepository.save(spending);
    }
}
