package tahafurkan.sandbox.familybudgetapp.service;

import tahafurkan.sandbox.familybudgetapp.model.Spending;
import tahafurkan.sandbox.familybudgetapp.model.dto.SpendingDto;

import java.util.List;

public interface SpendingService {

    public List<Spending> getAll();

    public List<Spending> getSpendingsByMonth(String spendingByMonth);

    public Spending create(SpendingDto spendingDto);
}
