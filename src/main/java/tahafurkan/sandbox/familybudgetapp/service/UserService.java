package tahafurkan.sandbox.familybudgetapp.service;

import tahafurkan.sandbox.familybudgetapp.model.Spending;
import tahafurkan.sandbox.familybudgetapp.model.User;

import java.util.List;

public interface UserService {

    public User get(int id);

    public List<User> getAll();

    public User getByUsername(String username);

    public List<Spending> getSpendingsByUserId(Integer id);
    public User getMostSpendingUser();

    public User create(User user);

    public User update(int id, User user);

    public void delete(int id);

    public void checkUsername(String username);
}
