package tahafurkan.sandbox.familybudgetapp.service;

import tahafurkan.sandbox.familybudgetapp.model.Spending;
import tahafurkan.sandbox.familybudgetapp.model.dto.SpendingRequestDto;

import java.util.Date;
import java.util.List;

public interface SpendingService {

    public List<Spending> getAll();

    public List<Spending> getSpendingsByDate(Date startDate, Date endDate);

    public Spending create(SpendingRequestDto spendingRequestDto);
}
