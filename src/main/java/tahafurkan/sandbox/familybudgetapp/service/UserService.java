package tahafurkan.sandbox.familybudgetapp.service;

import tahafurkan.sandbox.familybudgetapp.model.Spending;
import tahafurkan.sandbox.familybudgetapp.model.User;
import tahafurkan.sandbox.familybudgetapp.model.dto.UserSpendingDto;

import java.util.Date;
import java.util.List;

public interface UserService {

    public User get(int id);

    public List<User> getAll();

    public User getByUsername(String username);

    public List<Spending> getSpendingsByUserId(Integer id);

    public User findUserWithHighestTotalSpend();

    public User findHighestTotalSpendOnGivenDate(Date startDate, Date endDate);

    public List<UserSpendingDto> findHighestTotalSpendDetailsByDate(Date startDate, Date endDate);

    public User create(User user);

    public User update(int id, User user);

    public void delete(int id);

    public void checkUsername(String username);
}
